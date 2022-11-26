package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.dto.UserDeleteCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;
import team.study.common.base.utils.ValidationUtil;

import java.util.Objects;

/**
 * 删除用户能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:41
 */
@Service
public class UserDeleteAbility extends BaseAbility<UserDeleteCmd, Void> {
    private final UserRepository userRepository;

    public UserDeleteAbility(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserDeleteCmd abilityCmd) {
        //校验用户是否存在
        ValidationUtil.isFalse(Objects.isNull(userRepository.byId(abilityCmd.getId())), "USER_NOT_EXIST");
    }

    /**
     * @param abilityCmd abilityCmd
     * @return
     */
    @Override
    public Response checkIdempotent(UserDeleteCmd abilityCmd) {
        //todo 编写幂等校验逻辑
        return Response.buildSuccess();
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserDeleteCmd abilityCmd) {
        userRepository.delete(abilityCmd.getId());
        return Response.buildSuccess();
    }
}
