package study.team.leetcode.aggregate.user.repository;

import study.team.leetcode.aggregate.user.modal.User;
import team.study.common.base.model.ddd.Repository;

/**
 * 用户仓储接口
 *
 * @author JiaHao
 */
public interface UserRepository extends Repository<User, Long> {

    /**
     * 按照用户名查询用户
     *
     * @param userName 用户名
     * @return User
     */
    User byUserName(String userName);
}
