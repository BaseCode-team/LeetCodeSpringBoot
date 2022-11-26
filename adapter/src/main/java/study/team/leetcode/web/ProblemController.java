package study.team.leetcode.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.api.ProblemServiceI;
import study.team.leetcode.dto.ProblemCreateCmd;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import team.study.common.base.aop.WebLog;
import team.study.common.base.response.PageResponse;
import team.study.common.base.response.Response;

/**
 * 力扣问题控制器
 *
 * @author JiaHao
 */
@Api(tags = "力扣问题模块")
@ApiSupport(author = "JiaHao")
@RestController
public class ProblemController {

    private final ProblemServiceI problemService;

    public ProblemController(ProblemServiceI problemService) {
        this.problemService = problemService;
    }

    @ApiOperation(value = "查询力扣题目")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime"})
    @GetMapping(value = "/problem")
    @WebLog(description = "查询力扣题目信息")
    public PageResponse<LeetCodeProblemCO> problemList(LeetCodeProblemListQuery leetCodeProblemListQuery) {
        return problemService.list(leetCodeProblemListQuery);
    }

    @ApiOperation(value = "新增力扣题目")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime", "createTime"})
    @PostMapping(value = "/problem")
    @WebLog(description = "新增力扣题目信息")
    public Response addProblem(@RequestBody ProblemCreateCmd problemCreateCmd) {
        return problemService.createProblem(problemCreateCmd);
    }
}
