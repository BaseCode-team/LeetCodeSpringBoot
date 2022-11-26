package study.team.leetcode.repository.database.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.repository.database.po.UserPO;

/**
 * @author JiaHao
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2022-11-22 11:19:36
 */
public interface UserService extends IService<UserPO> {
    /**
     * @param cmd 用户列表查询命令
     * @return Page<UserPO>
     * @author JiaHao
     * @date 2022/11/22 17:14
     **/
    Page<UserPO> selectByPage(UserListQry cmd);
}
