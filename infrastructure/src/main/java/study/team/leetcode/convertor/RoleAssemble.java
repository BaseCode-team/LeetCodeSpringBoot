package study.team.leetcode.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.team.leetcode.aggregate.role.model.Role;
import study.team.leetcode.repository.database.po.RolePO;

/**
 * @author JiaHao
 */
@Mapper(componentModel = "spring")
public interface RoleAssemble {
    RoleAssemble INSTANCE = Mappers.getMapper(RoleAssemble.class);

    Role toRole(RolePO rolePO);
    //todo 转换deleted

    /**
     * @author JiaHao
     * @date 2022/11/22 16:31
     **/
    RolePO toRoleDO(Role role);
}
