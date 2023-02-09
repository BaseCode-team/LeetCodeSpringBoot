package study.team.leetcode.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.stereotype.Repository;
import study.team.leetcode.aggregate.role.model.Role;
import study.team.leetcode.aggregate.role.repository.RoleRepository;
import study.team.leetcode.convertor.RoleAssemble;
import study.team.leetcode.repository.database.po.RolePO;
import study.team.leetcode.repository.database.service.RoleService;
import team.study.common.base.aop.RepositoryLog;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色领域仓储
 *
 * @author JiaHao
 * @date 2022-11-22 13:26
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    private final RoleService service;

    public RoleRepositoryImpl(RoleService service) {
        this.service = service;
    }

    /**
     * @param ids id列表
     * @return List<Role>
     */
    @RepositoryLog(description = "根据id列表获取角色列表")
    @Override
    public List<Role> listByIds(List<Long> ids) {
        List<RolePO> rolePOS = service.listByIds(ids);
        if (CollectionUtils.isEmpty(rolePOS)) {
            return null;
        }
        return rolePOS.stream()
                .map(RoleAssemble.INSTANCE::toRole)
                .collect(Collectors.toList());
    }

    /**
     * @param aLong id
     */
    @RepositoryLog(description = "删除角色")
    @Override
    public void delete(Long aLong) {
        LambdaQueryWrapper<RolePO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RolePO::getId, aLong);
        service.getBaseMapper().delete(wrapper);

    }

    /**
     * @param aLong id
     * @return Role
     */
    @RepositoryLog(description = "根据id获取角色")
    @Override
    public Role byId(Long aLong) {
        LambdaQueryWrapper<RolePO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RolePO::getId, aLong);
        return RoleAssemble.INSTANCE.toRole(service.getBaseMapper().selectOne(wrapper));
    }

    /**
     * @param role 聚合根
     * @return Role
     */
    @RepositoryLog(description = "保存或更新角色")
    @Override
    public Role save(Role role) {
        RolePO rolePO = RoleAssemble.INSTANCE.toRoleDO(role);
        service.saveOrUpdate(rolePO);
        return RoleAssemble.INSTANCE.toRole(rolePO);
    }
}
