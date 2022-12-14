package study.team.leetcode.service;

import org.springframework.stereotype.Service;
import study.team.leetcode.api.UserServiceI;
import study.team.leetcode.commond.query.UserQryExe;
import study.team.leetcode.commond.user.*;
import study.team.leetcode.dto.*;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.dto.query.UserQry;
import team.study.common.base.response.Response;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户接口实现类
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:23
 */
@Service
public class AppUserServiceImpl implements UserServiceI {
    @Resource
    private UserCreateAbility userCreateAbility;
    @Resource
    private UserUpdateAbility userUpdateAbility;
    @Resource
    private UserDeleteAbility userDeleteAbility;
    @Resource
    private UserLoginAbility userLoginAbility;
    @Resource
    private UserLogoutAbility userLogoutAbility;
    @Resource
    private UserQryExe userQryExe;

    /**
     * @param cmd 用户登录信息
     * @return Response
     */
    @Override
    public Response login(UserLoginCmd cmd, HttpServletResponse response) {
        return userLoginAbility.executeAbility(cmd, response);
    }

    /**
     * @param cmd 用户登录信息
     * @return Response
     */
    @Override
    public Response logOut(UserLogoutCmd cmd) {
        return userLogoutAbility.executeAbility(cmd);
    }

    @Override
    public Response createUser(UserCreateCmd cmd) {
        return userCreateAbility.executeAbility(cmd);
    }

    @Override
    public Response updateUser(UserUpdateCmd cmd) {
        return userUpdateAbility.executeAbility(cmd);
    }

    @Override
    public Response getUserBy(UserQry qry) {
        return userQryExe.execute(qry);
    }

    @Override
    public Response listUserBy(UserListQry qry) {
        return userQryExe.execute(qry);
    }

    /**
     * @param cmd 删除用户命令
     * @return Response
     */
    @Override
    public Response deleteUser(UserDeleteCmd cmd) {
        return userDeleteAbility.executeAbility(cmd);
    }
}
