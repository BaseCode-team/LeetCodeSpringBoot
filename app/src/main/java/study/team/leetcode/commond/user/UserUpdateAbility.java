package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.convertor.UserAssemble;
import study.team.leetcode.dto.UserUpdateCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;
import team.study.common.base.response.SingleResponse;
import team.study.common.base.utils.ValidationUtil;

import java.util.Objects;

/**
 * 更新用户能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:38
 */
@Service
public class UserUpdateAbility extends BaseAbility<UserUpdateCmd, Void> {
    private final UserRepository userRepository;

    public UserUpdateAbility(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserUpdateCmd abilityCmd) {
        //todo 完成异常code的枚举类
        //校验用户是否存在
        ValidationUtil.isFalse(Objects.isNull(userRepository.byId(abilityCmd.getUserCO().getId())), "USER_NOT_EXIST");
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserUpdateCmd abilityCmd) {
        //todo 编写幂等校验逻辑
        return Response.buildSuccess();
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserUpdateCmd abilityCmd) {
        User user = UserAssemble.INSTANCE.toUser(abilityCmd.getUserCO());
        user.bindRole(abilityCmd.getUserCO().getRoleIds());
        // saveAndFlush 与 save 的区别在于: saveAndFlush会立即提交sql, 而save会到最后提交sql
        // 如果需要发送消息或者发布事件,建议使用saveAndFlush来保证事务一致性
        userRepository.save(user);
        return SingleResponse.of(Response.UPDATE_SUCCESS);
    }
}
