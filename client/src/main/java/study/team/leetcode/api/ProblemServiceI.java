package study.team.leetcode.api;

import study.team.leetcode.dto.ProblemCreateCmd;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import team.study.common.base.response.PageResponse;
import team.study.common.base.response.Response;

/**
 * 力扣问题接口
 *
 * @author JiaHao
 */
public interface ProblemServiceI {
    /**
     * 新增力扣题目
     *
     * @param problemCreateCmd 新增力扣题目命令
     * @return com.alibaba.cola.dto.Response
     * @author JiaHao
     * @methodName addProblem
     * @date 2022/11/8 19:27
     **/
    Response createProblem(ProblemCreateCmd problemCreateCmd);

    /**
     * 查询力扣题目
     *
     * @param leetCodeProblemListQuery 查询力扣题目命令
     * @return com.alibaba.cola.dto.MultiResponse<study.team.leetcode.dto.data.LeetCodeProblemVO>
     * @author JiaHao
     * @methodName listByName
     * @date 2022/11/8 19:27
     **/
    PageResponse<LeetCodeProblemCO> list(LeetCodeProblemListQuery leetCodeProblemListQuery);
}
