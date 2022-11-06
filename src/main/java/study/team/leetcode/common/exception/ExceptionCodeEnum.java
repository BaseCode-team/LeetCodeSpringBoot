package study.team.leetcode.common.exception;

import study.team.leetcode.common.response.IErrorCode;

/**
 * 异常枚举
 *
 * @author JiaHao
 */

public enum ExceptionCodeEnum implements IErrorCode {
    /**
     * 异常枚举
     * 数据格式不匹配与内部错误异常
     *
     * @date 2022/11/6 13:02
     **/
    BODY_NOT_MATCH(4000, "请求数据格式不符"),
    INTERNAL_SERVER_ERROR(5000, "服务器内部错误");

    private final long code;
    private final String message;

    ExceptionCodeEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
