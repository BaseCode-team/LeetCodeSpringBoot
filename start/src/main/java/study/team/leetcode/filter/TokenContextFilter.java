package study.team.leetcode.filter;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import io.undertow.server.HttpServerExchange;
import io.undertow.servlet.spec.HttpServletRequestImpl;
import io.undertow.util.HeaderMap;
import io.undertow.util.HttpString;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import study.team.leetcode.properties.MyIgnoreProperties;
import team.study.common.base.context.ContextConstants;
import team.study.common.base.context.ContextUtil;
import team.study.common.base.exception.AuthException;
import team.study.common.base.response.Response;
import team.study.common.base.utils.StrPool;
import team.study.common.jwt.TokenUtil;
import team.study.common.jwt.model.AuthInfo;
import team.study.common.jwt.utils.JwtUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static team.study.common.base.context.ContextConstants.*;

/**
 * Token校验类
 *
 * @author JiaHao
 * @date 2022-12-13 22:30
 */
@Component
@Slf4j
@WebFilter(filterName = "TokenContextFilter", urlPatterns = "/*")
@RequiredArgsConstructor
@EnableConfigurationProperties({MyIgnoreProperties.class})
public class TokenContextFilter implements Filter, Ordered {
    private final MyIgnoreProperties ignoreProperties;
    private final TokenUtil tokenUtil;
    @Value("${spring.profiles.active:dev}")
    protected String profiles;
    @Value("${my.database.multiTenantType:SCHEMA}")
    protected String multiTenantType;

    protected boolean isDev(String token) {
        return !StrPool.PROD.equalsIgnoreCase(profiles) && (StrPool.TEST_TOKEN.equalsIgnoreCase(token) || StrPool.TEST.equalsIgnoreCase(token));
    }

    @Override
    public int getOrder() {
        return -1000;
    }


    /**
     * 忽略 用户token
     */
    protected boolean isIgnoreToken(String path) {
        return ignoreProperties.isIgnoreToken(path);
    }

    /**
     * 忽略 租户编码
     */
    protected boolean isIgnoreTenant(String path) {
        return ignoreProperties.isIgnoreTenant(path);
    }

    protected String getHeader(String headerName, HttpServletRequest request) {
        String header = request.getHeader(headerName);
        String token = StrUtil.EMPTY;
        if (header == null || header.isEmpty()) {
            return token;
        }

        token = header;

        if (StrUtil.isNotBlank(token)) {
            return token;
        }

        return header;
    }

    private void parseToken(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 判断接口是否需要忽略token验证
        if (isIgnoreToken(request.getRequestURL().toString().replace("http://localhost:8080", ""))) {
            log.debug("当前接口：{}, 不解析用户token", request.getRequestURL().toString());
            return;
        }

        // 获取请求头中的token
        String token = getHeader(BEARER_HEADER_KEY, request);

        AuthInfo authInfo;
        // 测试环境 && token=test 时，写死一个用户信息，便于测试
        if (isDev(token)) {
            authInfo = new AuthInfo().setAccount("lamp").setUserId(2L)
                    .setTokenType(BEARER_HEADER_KEY).setName("超级管理员");
        } else {
            authInfo = tokenUtil.getAuthInfo(token);
        }

        // 将请求头中的token解析出来的用户信息重新封装到请求头，转发到业务服务
        // 业务服务在利用HeaderThreadLocalInterceptor拦截器将请求头中的用户信息解析到ThreadLocal中
        if (authInfo != null) {
            addHeader(servletRequest, ContextConstants.JWT_KEY_ACCOUNT, authInfo.getAccount());
            addHeader(servletRequest, ContextConstants.JWT_KEY_USER_ID, authInfo.getUserId());
            addHeader(servletRequest, ContextConstants.JWT_KEY_NAME, authInfo.getName());

            MDC.put(ContextConstants.JWT_KEY_USER_ID, String.valueOf(authInfo.getUserId()));
        }
    }

    private void parseClient(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String base64Authorization = getHeader(BASIC_HEADER_KEY, request);
        if (StrUtil.isNotEmpty(base64Authorization)) {
            String[] client = JwtUtil.getClient(base64Authorization);
            ContextUtil.setClientId(client[0]);
            addHeader(servletResponse, JWT_KEY_CLIENT_ID, ContextUtil.getClientId());
        }
    }

    private void parseTenant(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // NONE模式 直接忽略tenant
        if ("NONE".equals(multiTenantType)) {
            addHeader(servletResponse, JWT_KEY_TENANT, "_NONE");
            ContextUtil.setTenant("_NONE");
            MDC.put(JWT_KEY_TENANT, StrPool.EMPTY);
            return;
        }
        // 使请求忽略验证请求中的 租户编码(tenant) 参数
        if (isIgnoreTenant(request.getRequestURL().toString().replace("http://localhost:8080", ""))) {
            return;
        }
        String base64Tenant = getHeader(JWT_KEY_TENANT, request);
        if (StrUtil.isNotEmpty(base64Tenant)) {
            String tenant = JwtUtil.base64Decoder(base64Tenant);

            ContextUtil.setTenant(tenant);
            addHeader(servletResponse, JWT_KEY_TENANT, tenant);
            MDC.put(JWT_KEY_TENANT, tenant);
        }

        // 3.x 无需JWT_KEY_SUB_TENANT参数，请忽略
        String base64SubTenant = getHeader(JWT_KEY_SUB_TENANT, request);
        if (StrUtil.isNotEmpty(base64SubTenant)) {
            String subTenant = JwtUtil.base64Decoder(base64SubTenant);

            ContextUtil.setSubTenant(subTenant);
            addHeader(servletResponse, JWT_KEY_SUB_TENANT, subTenant);
            MDC.put(JWT_KEY_SUB_TENANT, subTenant);
        }
    }

    private void addHeader(ServletResponse servletResponse, String name, Object value) {
        if (value == null) {
            return;
        }
        String valueStr = value.toString();
        String valueEncode = URLUtil.encode(valueStr);
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader(name, valueEncode);
    }

    private void addHeader(ServletRequest servletRequest, String name, Object value) {
        if (value == null) {
            return;
        }
        String valueStr = value.toString();
        String valueEncode = URLUtil.encode(valueStr);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletRequestImpl request = (HttpServletRequestImpl) httpRequest;
        HttpServerExchange exchange = request.getExchange();
        HeaderMap headerMap = exchange.getRequestHeaders();
        headerMap.add(new HttpString(name), valueEncode);
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        try {
            //1, 解码 请求头中的租户信息
            parseTenant(servletRequest, servletResponse);

            // 2,解码 Authorization
            parseClient(servletRequest, servletResponse);

            // 3，解码 并验证 token
            parseToken(servletRequest, servletResponse, filterChain);
        } catch (AuthException e) {
            Response tokenError = Response.buildFailure(e.getErrCode(), e.getMessage());
            addHeader(servletResponse, HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            servletResponse.getOutputStream().write(tokenError.toString().getBytes(StandardCharsets.UTF_8));
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }
}
