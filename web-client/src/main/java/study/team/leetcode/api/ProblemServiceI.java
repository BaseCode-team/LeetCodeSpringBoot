package study.team.leetcode.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import study.team.leetcode.LeetCodeProblemListQuery;
import study.team.leetcode.dto.ProblemAddCmd;
import study.team.leetcode.dto.data.LeetCodeProblemDTO;

/**
 * @author JiaHao
 */
public interface ProblemServiceI {
    /**
     * 新增力扣题目
     *
     * @param problemAddCmd 新增力扣题目命令
     * @return com.alibaba.cola.dto.Response
     * @author JiaHao
     * @methodName addProblem
     * @date 2022/11/8 19:27
     **/
    Response addProblem(ProblemAddCmd problemAddCmd);

    /**
     * 查询力扣题目
     *
     * @param leetCodeProblemListQuery 查询力扣题目命令
     * @return com.alibaba.cola.dto.MultiResponse<study.team.leetcode.dto.data.LeetCodeProblemVO>
     * @author JiaHao
     * @methodName listByName
     * @date 2022/11/8 19:27
     **/

    MultiResponse<LeetCodeProblemDTO> list(LeetCodeProblemListQuery leetCodeProblemListQuery);
}
