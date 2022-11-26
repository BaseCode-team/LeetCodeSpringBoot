package study.team.leetcode.aggregate.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.role.model.Role;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.service.UserDomainService;

import java.util.List;

/**
 * 用户领域服务
 *
 * @author JiaHao
 */
@Service
@Slf4j
public class UserDomainServiceImpl implements UserDomainService {

    @Override
    public void printTag(User user, List<Role> roles) {
        roles.forEach(role -> {
            //省略大量逻辑
            if (role.isAdmin()) {
                log.info("用户：{}的标签解析为：{}", user.getUserName(), role.getName());
            }
        });
    }
}
