package study.team.leetcode.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.api.SolutionServiceI;
import study.team.leetcode.dto.SolutionCreateCmd;
import team.study.common.base.response.Response;

/**
 * 题解控制器
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022 -11-10 08:56
 */
@Api(tags = "力扣题解模块")
@ApiSupport(author = "JiaHao")
@RestController
public class SolutionController {

    private final SolutionServiceI solutionService;

    /**
     * Instantiates a new Solution controller.
     *
     * @param solutionService the solution service
     */
    public SolutionController(SolutionServiceI solutionService) {
        this.solutionService = solutionService;
    }

    /**
     * Add solution response.
     *
     * @param solutionCreateCmd the solution add cmd
     * @return the response
     */
    @ApiOperation(value = "新增题解")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime", "createTime"})
    @PostMapping(value = "/solution")
    public Response addSolution(@RequestBody SolutionCreateCmd solutionCreateCmd) {
        return solutionService.addSolution(solutionCreateCmd);
    }
}
