package study.team.leetcode.aggregate.user.modal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import study.team.leetcode.aggregate.role.repository.RoleRepository;
import study.team.leetcode.share.valueobject.Address;
import team.study.common.base.model.ddd.AggregateRoot;
import team.study.common.base.utils.ValidationUtil;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户聚合根
 *
 * @author JiaHao
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@JsonIgnoreProperties({"roleRepository"})
public class User implements AggregateRoot {

    @JSONField(serialize = false)
    private RoleRepository roleRepository;
    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户真实名称
     */
    private String realName;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户地址
     */
    private Address address;

    /**
     * 角色实体
     */
    private List<Role> roles;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> paraseStr(String roles) {
        List<Long> roleIds = Arrays.stream(roles.split(",")).map(Long::valueOf).toList();
        return roleIds.stream()
                .map(id -> {
                    Role role = new Role();
                    role.setRoleRepository(roleRepository);
                    role.bindrole(id);
                    return role;
                })
                .collect(Collectors.toList());
    }

    /**
     * 根据角色id设置角色信息
     *
     * @param roleIds 角色id
     */
    public void bindRole(List<Long> roleIds) {
        this.roles = roleIds.stream()
                .map(id -> {
                    Role role = new Role();
                    role.setRoleRepository(roleRepository);
                    role.bindrole(id);
                    return role;
                })
                .collect(Collectors.toList());
    }

    /**
     * 设置角色信息
     *
     * @param roles 角色ids
     */
    public void bindRole(String roles) {
        List<Long> roleIds = Arrays.stream(roles.split(",")).map(Long::valueOf).toList();
        this.roles = roleIds.stream()
                .map(id -> {
                    Role role = new Role();
                    role.setRoleRepository(roleRepository);
                    role.bindrole(id);
                    return role;
                })
                .collect(Collectors.toList());
    }

    /**
     * 设置用户地址信息
     *
     * @param province 省
     * @param city     市
     * @param county   区
     */
    public void bindAddress(String province, String city, String county) {
        this.address = new Address(province, city, county);
    }


    /**
     * 修改用户名
     *
     * @param userName  修改后的用户名
     * @param existUser 根据修改后的用户名查询出来用户
     */
    public void bindUserName(String userName, User existUser) {
        ValidationUtil.isTrue(Objects.isNull(existUser) || Objects.equals(existUser.getId(), this.id), "user.user.name.is.exist");
        this.userName = userName;
    }

    /**
     * 演示修改业务逻辑
     */
    public void printUpdate() {
        //此处省略100行代码
        log.info(this.userName + "发生修改");
    }

    /**
     * 演示新增业务逻辑
     */
    public void printCreate() {
        //此处省略100行代码
        log.info(this.userName + "发生新增");
    }

}
