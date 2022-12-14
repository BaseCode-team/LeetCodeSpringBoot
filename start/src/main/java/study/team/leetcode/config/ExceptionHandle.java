package study.team.leetcode.config;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.study.common.base.handle.AbstractGlobalExceptionHandler;

/**
 * 异常处理类（框架中已经写好大部分异常处理，直接继承扩展即可）
 *
 * @author JiaHao
 * @date 2022-11-23 20:57
 */
@RestControllerAdvice
public class ExceptionHandle extends AbstractGlobalExceptionHandler {
}
