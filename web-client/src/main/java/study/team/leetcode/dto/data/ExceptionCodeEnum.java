package study.team.leetcode.dto.data;

/**
 * 异常枚举
 *
 * @author JiaHao
 */

public enum ExceptionCodeEnum {
    /**
     * 异常枚举
     * 数据格式不匹配与内部错误异常
     *
     * @date 2022/11/6 13:02
     **/
    BODY_NOT_MATCH("4000", "请求数据格式不符"),
    INTERNAL_SERVER_ERROR("5000", "服务器内部错误");


    private final String errCode;
    private final String errDesc;

    ExceptionCodeEnum(String errCode, String errDesc) {
        this.errCode = errCode;
        this.errDesc = errDesc;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrDesc() {
        return errDesc;
    }
}
