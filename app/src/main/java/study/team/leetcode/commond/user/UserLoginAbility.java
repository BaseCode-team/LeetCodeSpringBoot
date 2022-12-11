package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.dto.UserLoginCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;
import team.study.common.base.response.SingleResponse;

/**
 * 用户登录能力
 *
 * @author JiaHao
 * @date 2022-12-11 14:17
 */
@Service
public class UserLoginAbility extends BaseAbility<UserLoginCmd, Void> {
    private final UserRepository userRepository;


    public UserLoginAbility(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserLoginCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserLoginCmd abilityCmd) {
        //todo 编写幂等校验逻辑
        return Response.buildSuccess();
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserLoginCmd abilityCmd) {
        User user = userRepository.byUserName(abilityCmd.getUserCO().getUserName());
        if (user != null && user.getPassword().equals(abilityCmd.getUserCO().getPassword())) {
            return SingleResponse.of(user);
        }
        return Response.buildFailure("1", "用户名或密码不正确");
    }
}
