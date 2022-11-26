package study.team.leetcode.commond.user;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.role.model.Role;
import study.team.leetcode.aggregate.role.repository.RoleRepository;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.aggregate.user.service.UserDomainService;
import study.team.leetcode.convertor.UserAssemble;
import study.team.leetcode.dto.UserCreateCmd;
import study.team.leetcode.share.AbilityContext;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;
import team.study.common.base.response.SingleResponse;
import team.study.common.base.utils.ValidationUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 创建用户能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:12
 */
@Service
public class UserCreateAbility extends BaseAbility<UserCreateCmd, Void> {
    private final static String ROLE_INFO_KEY = "roleInfo";
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserDomainService userDomainService;

    public UserCreateAbility(UserRepository userRepository, RoleRepository roleRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userDomainService = userDomainService;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserCreateCmd abilityCmd) {
        //todo 完成异常code的枚举类
        //校验用户名不存在
        ValidationUtil.isTrue(Objects.isNull(userRepository.byUserName(abilityCmd.getUserCO().getUserName())), "USER_ALREADY_EXIST");
        List<Long> roleIds = Arrays.stream(abilityCmd.getUserCO().getRoleIds().split(",")).map(Long::valueOf).toList();
        //校验角色存在
        List<Role> roles = roleRepository.listByIds(roleIds);
        ValidationUtil.isTrue(CollectionUtils.isNotEmpty(roles) &&
                        Objects.equals(roles.size(), roleIds.size()),
                "ROLE_NOT_EXIST");
        AbilityContext.putValue(ROLE_INFO_KEY, roles);
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserCreateCmd abilityCmd) {
        return Response.buildSuccess();
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserCreateCmd abilityCmd) {
        User user = UserAssemble.INSTANCE.toUser(abilityCmd.getUserCO());
        user.bindRole(abilityCmd.getUserCO().getRoleIds());
        userRepository.save(user);
        userDomainService.printTag(user, AbilityContext.getValue(ROLE_INFO_KEY));
        return SingleResponse.of(Response.INSERT_SUCCESS);
    }
}
