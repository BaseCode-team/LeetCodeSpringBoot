package study.team.leetcode.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import team.study.common.base.config.IgnoreProperties;

/**
 * 忽略验证接口配置
 *
 * @author JiaHao
 * @date 2022-12-14 11:57
 */
@Configuration
@Primary
public class MyIgnoreProperties extends IgnoreProperties {

}
