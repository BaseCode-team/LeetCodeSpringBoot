package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.aggregate.user.repository.UserRepository;
import study.team.leetcode.dto.UserLogoutCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;

/**
 * 用户登出能力
 *
 * @author JiaHao
 * @date 2022-12-11 14:17
 */
@Service
public class UserLogoutAbility extends BaseAbility<UserLogoutCmd, Void> {
    private final UserRepository userRepository;

    public UserLogoutAbility(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserLogoutCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserLogoutCmd abilityCmd) {
        //todo 编写幂等校验逻辑
        return Response.buildSuccess();
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserLogoutCmd abilityCmd) {
        return Response.buildSuccess();
    }
}
