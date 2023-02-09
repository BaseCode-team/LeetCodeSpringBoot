package study.team.leetcode.service;

import org.springframework.stereotype.Service;
import study.team.leetcode.api.ProblemServiceI;
import study.team.leetcode.commond.problem.ProblemCreateAbility;
import study.team.leetcode.commond.query.LeetCodeProblemQueryExe;
import study.team.leetcode.dto.ProblemCreateCmd;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import team.study.common.base.response.PageResponse;
import team.study.common.base.response.Response;

import javax.annotation.Resource;

/**
 * 力扣问题接口实现类
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 19:32
 */
@Service
public class ProblemServiceImpl implements ProblemServiceI {
    @Resource
    private ProblemCreateAbility problemCreateAbility;

    @Resource
    private LeetCodeProblemQueryExe leetCodeProblemQueryExe;

    @Override
    public Response createProblem(ProblemCreateCmd problemCreateCmd) {
        return problemCreateAbility.executeAbility(problemCreateCmd);
    }

    @Override
    public PageResponse<LeetCodeProblemCO> list(LeetCodeProblemListQuery leetCodeProblemListQuery) {
        return leetCodeProblemQueryExe.execute(leetCodeProblemListQuery);
    }
}
