package study.team.leetcode.application.algorithm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-06-26 18:15
 * @description test Knife4J
 */
@Api(tags = "首页模块")
@RestController
@ResponseBody
public class IndexController {

    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name", required = false, defaultValue = "cjh")String name){
        return ResponseEntity.ok("Hi:"+name);
    }
}
