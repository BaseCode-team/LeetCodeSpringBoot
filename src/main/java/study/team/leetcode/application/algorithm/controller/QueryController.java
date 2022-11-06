package study.team.leetcode.application.algorithm.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.application.algorithm.queryDTO.LeetCodeProblemQueryDTO;
import study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO;
import study.team.leetcode.common.response.CommonResult;
import study.team.leetcode.common.response.ResultCodeEnum;
import study.team.leetcode.infra.repository.algorithm.QueryRepository;

import java.util.List;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-05 14:25
 * @description 算法模块查询相关接口
 */
@Api(tags = "查询模块")
@Slf4j
@RestController
@RequestMapping("query")
@ApiSupport(author = "JiaHao")
public class QueryController {
    private final QueryRepository repository;

    public QueryController(QueryRepository repository) {
        this.repository = repository;
    }

    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"description", "updateTime"})
    @ApiOperation(value = "具体精确查询（单个）")
    @GetMapping("/one")
    public CommonResult<LeetCodeProblemVO> getOne(LeetCodeProblemQueryDTO dto) {
        LeetCodeProblemVO result = repository.queryOne(dto);
        if (result == null) {
            log.warn(ResultCodeEnum.NO_CONTENT.getMessage());
            return CommonResult.failed(ResultCodeEnum.NO_CONTENT);
        }
        return CommonResult.success(result);
    }

    @ApiOperation(value = "条件查询（多个）")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime"})
    @GetMapping("/list")
    public CommonResult<List<LeetCodeProblemVO>> getList(LeetCodeProblemQueryDTO dto) {
        List<LeetCodeProblemVO> result = repository.queryList(dto);
        if (result.size() == 0) {
            log.warn(ResultCodeEnum.NO_CONTENT.getMessage());
            return CommonResult.failed(ResultCodeEnum.NO_CONTENT);
        }
        return CommonResult.success(result);
    }

}
