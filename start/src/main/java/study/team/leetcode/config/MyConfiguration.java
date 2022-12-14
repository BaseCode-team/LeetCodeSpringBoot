package study.team.leetcode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import team.study.common.base.config.BaseConfig;
import team.study.common.base.config.GlobalMvcConfigurer;
import team.study.common.jwt.JwtProperties;
import team.study.common.jwt.TokenUtil;

/**
 * 我的配置类
 *
 * @author JiaHao
 * @date 2022-12-13 18:44
 */
@Configuration
public class MyConfiguration extends BaseConfig {
    @Bean
    public TokenUtil getTokenUtil() {
        return new TokenUtil(new JwtProperties());
    }

    @Bean
    public GlobalMvcConfigurer myMvcConfigurer() {
        return new GlobalMvcConfigurer();
    }
}
