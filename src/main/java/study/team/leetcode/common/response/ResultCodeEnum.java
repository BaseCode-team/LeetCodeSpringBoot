package study.team.leetcode.common.response;

/**
 * @author JiaHao
 */

public enum ResultCodeEnum implements IErrorCode {
    /**
     * 返回结果枚举
     *
     * @date 2022/11/6 13:02
     **/
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    NO_CONTENT(203, "内容为空"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private final long code;
    private final String message;

    ResultCodeEnum(long code, String message) {
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
