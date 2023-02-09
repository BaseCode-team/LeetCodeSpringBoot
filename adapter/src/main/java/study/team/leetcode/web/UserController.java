package study.team.leetcode.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.team.leetcode.api.UserServiceI;
import study.team.leetcode.dto.UserCreateCmd;
import study.team.leetcode.dto.UserDeleteCmd;
import study.team.leetcode.dto.UserUpdateCmd;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.dto.query.UserQry;
import team.study.common.base.aop.WebLog;
import team.study.common.base.exception.ValidGroup;
import team.study.common.base.response.Response;

/**
 * 用户控制器
 *
 * @author JiaHao
 * @date 2022-11-22 16:33
 */
@Api(tags = "用户模块")
@ApiSupport(author = "JiaHao")
@RestController
@Validated
public class UserController {
    private final UserServiceI service;

    public UserController(UserServiceI service) {
        this.service = service;
    }

    @ApiOperation(value = "查询用户列表")
    @ApiOperationSupport(author = "JiaHao")
    @GetMapping(value = "/user/list")
    @WebLog(description = "查询用户列表信息")
    public Response userList(@Validated(ValidGroup.Query.class) UserListQry qry) {
        return service.listUserBy(qry);
    }

    @ApiOperation(value = "查询单个用户")
    @ApiOperationSupport(author = "JiaHao")
    @GetMapping(value = "/user/one")
    @WebLog(description = "查询单个用户信息")
    public Response getUser(@Validated(ValidGroup.Query.class) UserQry qry) {
        return service.getUserBy(qry);
    }

    @ApiOperation(value = "新增用户")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime", "createTime"})
    @PostMapping(value = "/user")
    @WebLog(description = "新增用户信息")
    public Response addUser(@RequestBody @Validated(ValidGroup.Create.class) UserCreateCmd cmd) {
        return service.createUser(cmd);
    }

    @ApiOperation(value = "更新用户")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime", "createTime"})
    @PutMapping(value = "/user")
    @WebLog(description = "更新用户信息")
    public Response updateUser(@RequestBody @Validated(ValidGroup.Update.class) UserUpdateCmd cmd) {
        return service.updateUser(cmd);
    }

    @ApiOperation(value = "删除用户")
    @ApiOperationSupport(author = "JiaHao", ignoreParameters = {"updateTime", "createTime"})
    @DeleteMapping(value = "/user")
    @WebLog(description = "删除用户信息")
    public Response deleteUser(@Validated(ValidGroup.Update.class) UserDeleteCmd cmd) {
        return service.deleteUser(cmd);
    }
}
