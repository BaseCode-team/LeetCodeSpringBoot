package study.team.leetcode.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Repository;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.convertor.UserAssemble;
import study.team.leetcode.repository.database.po.UserPO;
import study.team.leetcode.repository.database.service.UserService;
import team.study.common.base.aop.RepositoryLog;

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

    public UserRepositoryImpl(UserService service, ConversionService conversionService) {
        this.service = service;
    }

    /**
     * @param userName 用户名
     * @return User
     */
    @RepositoryLog(description = "按照用户名查询用户")
    @Override
    public User byUserName(String userName) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getUserName, userName);
        return UserAssemble.INSTANCE.toUser(service.getBaseMapper().selectOne(wrapper));
    }

    /**
     * @param aLong id
     */
    @RepositoryLog(description = "删除用户")
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
    @RepositoryLog(description = "按照id查询用户")
    @Override
    public User byId(Long aLong) {
        LambdaQueryWrapper<UserPO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserPO::getId, aLong);
        return UserAssemble.INSTANCE.toUser(service.getBaseMapper().selectOne(wrapper));
    }

    /**
     * @param user 聚合根
     * @return 聚合根
     */
    @RepositoryLog(description = "保存或更新聚合根")
    @Override
    public User save(User user) {
        UserPO userPO = UserAssemble.INSTANCE.toUserDO(user);
        service.saveOrUpdate(userPO);
        return UserAssemble.INSTANCE.toUser(userPO);
    }
}
