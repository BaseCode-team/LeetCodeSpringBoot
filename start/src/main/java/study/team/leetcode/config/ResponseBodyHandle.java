package study.team.leetcode.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import study.team.leetcode.properties.MyIgnoreProperties;
import team.study.common.base.handle.AbstractGlobalResponseBodyAdvice;

/**
 * 统一包装返回体
 *
 * @author JiaHao
 * @date 2022-12-13 18:37
 */
@ControllerAdvice
public class ResponseBodyHandle extends AbstractGlobalResponseBodyAdvice {

    public ResponseBodyHandle(MyIgnoreProperties ignoreProperties) {
        super(ignoreProperties);
    }
}
