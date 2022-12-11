package study.team.leetcode.aggregate.user.modal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import study.team.leetcode.aggregate.role.repository.RoleRepository;

/**
 * 角色实体
 *
 * @author JiaHao
 */
@Data
@JsonIgnoreProperties({"roleRepository"})
public class Role {

    @JSONField(serialize = false)
    private RoleRepository roleRepository;
    /**
     * 角色id
     */
    private Long id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;

    public Role bindrole(Long id) {
        study.team.leetcode.aggregate.role.model.Role role = roleRepository.byId(id);
        this.id = role.getId();
        this.code = role.getCode();
        this.name = role.getName();
        return this;
    }
}
