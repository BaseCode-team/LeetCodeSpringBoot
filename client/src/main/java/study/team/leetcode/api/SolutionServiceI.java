package study.team.leetcode.api;

import study.team.leetcode.dto.SolutionCreateCmd;
import team.study.common.base.response.Response;

/**
 * 力扣题解接口
 *
 * @author JiaHao
 */
public interface SolutionServiceI {
    /**
     * 新增题解
     *
     * @param cmd 新增题解命令
     * @return com.alibaba.cola.dto.Response
     * @author JiaHao
     * @methodName addSolution
     * @date 2022/11/10 9:00
     **/
    Response addSolution(SolutionCreateCmd cmd);
}
