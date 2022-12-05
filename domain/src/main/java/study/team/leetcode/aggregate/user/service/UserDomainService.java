package study.team.leetcode.aggregate.user.service;


import study.team.leetcode.aggregate.role.model.Role;
import study.team.leetcode.aggregate.user.modal.User;
import team.study.common.base.model.ddd.DomainService;

import java.util.List;

/**
 * 用户领域服务
 *
 * @author JiaHao
 */
public interface UserDomainService extends DomainService {

    /**
     * 需要用户角色两个聚合完成用户聚合的原子化逻辑
     * <p>
     * 根据用户关联的角色打印出标签
     *
     * @param user  用户聚合
     * @param roles 角色聚合
     */
    void printTag(User user, List<Role> roles);
}
