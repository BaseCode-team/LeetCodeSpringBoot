package study.team.leetcode.problem;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import org.springframework.stereotype.Service;
import study.team.leetcode.LeetCodeProblemListQuery;
import study.team.leetcode.api.ProblemServiceI;
import study.team.leetcode.dto.ProblemAddCmd;
import study.team.leetcode.dto.data.LeetCodeProblemDTO;
import study.team.leetcode.problem.excutor.ProblemAddCmdExe;
import study.team.leetcode.problem.excutor.query.LeetCodeProblemListQueryExe;

import javax.annotation.Resource;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 19:32
 * @description ProblemServiceI 实现类
 */
@Service
@CatchAndLog
public class ProblemServiceImpl implements ProblemServiceI {
    @Resource
    private ProblemAddCmdExe problemAddCmdExe;

    @Resource
    private LeetCodeProblemListQueryExe leetCodeProblemListQueryExe;

    @Override
    public Response addProblem(ProblemAddCmd problemAddCmd) {
        return problemAddCmdExe.execute(problemAddCmd);
    }

    @Override
    public MultiResponse<LeetCodeProblemDTO> list(LeetCodeProblemListQuery leetCodeProblemListQuery) {
        return leetCodeProblemListQueryExe.execute(leetCodeProblemListQuery);
    }
}
