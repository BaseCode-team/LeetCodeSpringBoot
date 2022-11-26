package study.team.leetcode.api;

import study.team.leetcode.dto.UserCreateCmd;
import study.team.leetcode.dto.UserDeleteCmd;
import study.team.leetcode.dto.UserUpdateCmd;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.dto.query.UserQry;
import team.study.common.base.response.Response;

/**
 * 用户接口
 *
 * @author JiaHao
 */
public interface UserServiceI {
    /**
     * 新增用户
     *
     * @param cmd 新增用户命令
     * @return Response
     * @author JiaHao
     * @methodName createUser
     * @date 2022/11/10 8:17
     **/
    Response createUser(UserCreateCmd cmd);

    /**
     * 更新用户
     *
     * @param cmd 更新用户命令
     * @return Response
     * @author JiaHao
     * @methodName updateUser
     * @date 2022/11/10 8:17
     **/
    Response updateUser(UserUpdateCmd cmd);

    /**
     * 查询单个用户
     *
     * @param qry 单个用户查询条件
     * @return Response
     * @author JiaHao
     * @methodName getUserBy
     * @date 2022/11/10 8:17
     **/
    Response getUserBy(UserQry qry);

    /**
     * 查询多个用户
     *
     * @param qry 多用户查询条件
     * @return Response
     * @author JiaHao
     * @methodName listUserBy
     * @date 2022/11/10 8:18
     **/
    Response listUserBy(UserListQry qry);

    /**
     * 删除用户
     *
     * @param cmd 删除用户命令
     * @return Response
     * @author JiaHao
     * @date 2022/11/26 10:06
     **/
    Response deleteUser(UserDeleteCmd cmd);
}
