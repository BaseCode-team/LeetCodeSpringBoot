package study.team.leetcode.application.algorithm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.application.algorithm.queryDTO.LeetCodeProblemQueryDTO;
import study.team.leetcode.infra.repository.algorithm.QueryRepository;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-05 14:25
 * @description 算法模块查询相关接口
 */
@Api(tags = "查询模块")
@RestController
@RequestMapping("query")
public class QueryController {
    private final QueryRepository repository;
    public QueryController(QueryRepository repository){
        this.repository = repository;
    }

    @ApiOperation(value = "具体精确查询（单个）")
    @GetMapping("/one")
    public ResponseEntity<Object> getOne(LeetCodeProblemQueryDTO dto){
        return ResponseEntity.ok(repository.queryOne(dto));
    }

    @ApiOperation(value = "条件查询（多个）")
    @GetMapping("/list")
    public ResponseEntity<Object> getList(LeetCodeProblemQueryDTO dto){
        return ResponseEntity.ok(repository.queryList(dto));
    }

}
