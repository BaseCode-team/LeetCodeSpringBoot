package study.team.leetcode.aggregate.role.repository;

import study.team.leetcode.aggregate.role.model.Role;
import team.study.common.base.model.ddd.Repository;

import java.util.List;

/**
 * 用户仓储接口
 *
 * @author JiaHao
 */
public interface RoleRepository extends Repository<Role, Long> {

    /**
     * 根据id列表获取角色列表
     *
     * @param ids id列表
     * @return List<Role>
     */
    List<Role> listByIds(List<Long> ids);
}
