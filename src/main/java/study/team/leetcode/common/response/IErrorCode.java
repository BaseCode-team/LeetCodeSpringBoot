package study.team.leetcode.common.response;

/**
 * @author JiaHao
 */
public interface IErrorCode {
    /**
     * 返回码
     *
     * @return long
     * @author JiaHao
     * @methodName getCode
     * @date 2022/11/6 13:06
     **/
    long getCode();

    /**
     * 返回信息
     *
     * @return java.lang.String
     * @author JiaHao
     * @methodName getMessage
     * @date 2022/11/6 13:06
     **/
    String getMessage();
}

