package study.team.leetcode.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import study.team.leetcode.common.response.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-06 19:50
 * @description 自定义全局异常类
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     *
     * @param req-请求体
     * @param e-异常
     * @return CommonResult<Object>
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public CommonResult<Object> bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return CommonResult.failed(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req-请求体
     * @param e-异常
     * @return CommonResult<Object>
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonResult<Object> exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return CommonResult.failed(ExceptionCodeEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     *
     * @param req-请求体
     * @param e-异常
     * @return CommonResult<Object>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult<Object> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是:", e);
        return CommonResult.failed(ExceptionCodeEnum.INTERNAL_SERVER_ERROR);
    }
}
