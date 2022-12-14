package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.dto.UserLoginCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.context.ContextConstants;
import team.study.common.base.response.Response;
import team.study.common.base.response.SingleResponse;
import team.study.common.jwt.JwtProperties;
import team.study.common.jwt.TokenUtil;
import team.study.common.jwt.model.AuthInfo;
import team.study.common.jwt.model.JwtUserInfo;

import javax.servlet.http.HttpServletResponse;

import static team.study.common.base.context.ContextConstants.BEARER_HEADER_KEY;

/**
 * 用户登录能力
 *
 * @author JiaHao
 * @date 2022-12-11 14:17
 */
@Service
public class UserLoginAbility extends BaseAbility<UserLoginCmd, Void> {
    private final UserRepository userRepository;
    private final TokenUtil tokenUtil;


    public UserLoginAbility(UserRepository userRepository, TokenUtil tokenUtil) {
        this.userRepository = userRepository;
        this.tokenUtil = tokenUtil;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserLoginCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserLoginCmd abilityCmd) {
        //todo 编写幂等校验逻辑
        return Response.buildSuccess();
    }

    public Response executeAbility(UserLoginCmd abilityCmd, HttpServletResponse response) {
        User user = userRepository.byUserName(abilityCmd.getUserCO().getUserName());
        if (user != null && user.getPassword().equals(abilityCmd.getUserCO().getPassword())) {
            JwtUserInfo jwtUserInfo = new JwtUserInfo();
            jwtUserInfo.setAccount(user.getUserName());
            jwtUserInfo.setUserId(user.getId());
            jwtUserInfo.setName(user.getRealName());
            AuthInfo authInfo = tokenUtil.createAuthInfo(jwtUserInfo, null);
            response.setHeader(BEARER_HEADER_KEY, ContextConstants.BEARER_HEADER_PREFIX + authInfo.getToken());
            return SingleResponse.of(authInfo.getToken());
        }
        return Response.buildFailure("1", "用户名或密码不正确");
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserLoginCmd abilityCmd) {
        User user = userRepository.byUserName(abilityCmd.getUserCO().getUserName());
        if (user != null && user.getPassword().equals(abilityCmd.getUserCO().getPassword())) {
            JwtProperties properties = new JwtProperties();
            JwtUserInfo jwtUserInfo = new JwtUserInfo();
            jwtUserInfo.setAccount(user.getUserName());
            jwtUserInfo.setUserId(user.getId());
            jwtUserInfo.setName(user.getRealName());
            AuthInfo authInfo = new TokenUtil(properties).createAuthInfo(jwtUserInfo, null);

            return SingleResponse.of(authInfo.getToken());
        }
        return Response.buildFailure("1", "用户名或密码不正确");
    }
}
