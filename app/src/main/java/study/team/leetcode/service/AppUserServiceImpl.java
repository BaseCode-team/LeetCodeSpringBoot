package study.team.leetcode.service;

import org.springframework.stereotype.Service;
import study.team.leetcode.api.UserServiceI;
import study.team.leetcode.commond.query.UserQryExe;
import study.team.leetcode.commond.user.UserCreateAbility;
import study.team.leetcode.commond.user.UserDeleteAbility;
import study.team.leetcode.commond.user.UserUpdateAbility;
import study.team.leetcode.dto.UserCreateCmd;
import study.team.leetcode.dto.UserDeleteCmd;
import study.team.leetcode.dto.UserUpdateCmd;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.dto.query.UserQry;
import team.study.common.base.response.Response;

import javax.annotation.Resource;

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
    private UserQryExe userQryExe;

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
