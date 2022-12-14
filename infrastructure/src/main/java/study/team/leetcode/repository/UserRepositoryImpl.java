package study.team.leetcode.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import study.team.leetcode.aggregate.role.repository.RoleRepository;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.convertor.UserAssemble;
import study.team.leetcode.repository.database.po.UserPO;
import study.team.leetcode.repository.database.service.UserService;

/**
 * 用户仓储接口实现
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:46
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    public final UserService service;
    public final RoleRepository roleRepository;

    public UserRepositoryImpl(UserService service, RoleRepository roleRepository) {
        this.service = service;
        this.roleRepository = roleRepository;
    }

    /**
     * @param userName 用户名
     * @return User
     */

    @Override
    public User byUserName(String userName) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getUserName, userName);
        UserPO userPO = service.getBaseMapper().selectOne(wrapper);
        if (userPO == null) {
            return null;
        }
        User user = UserAssemble.INSTANCE.toUser(userPO);
        user.setRoleRepository(roleRepository);
        user.bindRole(userPO.getRoleIds());
        return user;
    }

    /**
     * @param aLong id
     */

    @Override
    public void delete(Long aLong) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getId, aLong);
        service.getBaseMapper().delete(wrapper);
    }

    /**
     * @param aLong id
     * @return User
     */
    @Override
    public User byId(Long aLong) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getId, aLong);
        UserPO userPO = service.getBaseMapper().selectOne(wrapper);
        if (userPO == null) {
            return null;
        }
        User user = UserAssemble.INSTANCE.toUser(userPO);
        user.setRoleRepository(roleRepository);
        user.paraseStr(userPO.getRoleIds());
        return user;
    }

    /**
     * @param user 聚合根
     * @return 聚合根
     */

    @Override
    public User save(User user) {
        UserPO userPO = UserAssemble.INSTANCE.toUserDO(user);
        service.saveOrUpdate(userPO);
        User newUser = UserAssemble.INSTANCE.toUser(userPO);
        newUser.setRoleRepository(roleRepository);
        newUser.paraseStr(userPO.getRoleIds());
        return newUser;
    }
}
