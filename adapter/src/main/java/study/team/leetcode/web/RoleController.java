package study.team.leetcode.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.team.leetcode.api.RoleServiceI;
import team.study.common.base.aop.WebLog;
import team.study.common.base.response.Response;

/**
 * 角色控制器
 *
 * @author JiaHao
 * @date 2022-12-11 15:37
 */
@Api(tags = "角色模块")
@ApiSupport(author = "JiaHao")
@RestController
@Validated
public class RoleController {
    private final RoleServiceI service;

    public RoleController(RoleServiceI service) {
        this.service = service;
    }

    @ApiOperation(value = "获取全部角色信息")
    @ApiOperationSupport(author = "JiaHao")
    @GetMapping(value = "/roles")
    @WebLog(description = "获取全部角色信息")
    public Response getAllRoles() {
        return service.getRoles();
    }
}
