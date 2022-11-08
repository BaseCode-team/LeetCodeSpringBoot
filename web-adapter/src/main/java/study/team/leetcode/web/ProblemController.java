package study.team.leetcode.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.LeetCodeProblemListQuery;
import study.team.leetcode.api.ProblemServiceI;
import study.team.leetcode.dto.ProblemAddCmd;
import study.team.leetcode.dto.data.LeetCodeProblemDTO;

/**
 * @author JiaHao
 */
@Api(tags = "查询模块")
@ApiSupport(author = "JiaHao")
@RestController
public class ProblemController {

    private final ProblemServiceI problemService;

    public ProblemController(ProblemServiceI problemService) {
        this.problemService = problemService;
    }

    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "Hello, welcome to COLA world!";
    }

    @ApiOperation(value = "查询力扣题目")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime"})
    @GetMapping(value = "/problem")
    public MultiResponse<LeetCodeProblemDTO> list(LeetCodeProblemListQuery leetCodeProblemListQuery) {
        return problemService.list(leetCodeProblemListQuery);
    }

    @ApiOperation(value = "新增力扣题目")
    @ApiOperationSupport(author = "JiaHao")
    @PostMapping(value = "/problem")
    public Response addCustomer(@RequestBody ProblemAddCmd problemAddCmd) {
        return problemService.addProblem(problemAddCmd);
    }
}
