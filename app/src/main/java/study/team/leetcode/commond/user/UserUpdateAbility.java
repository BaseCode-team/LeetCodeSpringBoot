package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.dto.UserUpdateCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;

/**
 * 更新用户能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:38
 */
@Service
public class UserUpdateAbility extends BaseAbility<UserUpdateCmd, Void> {
    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserUpdateCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(UserUpdateCmd abilityCmd) {
        return null;
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserUpdateCmd abilityCmd) {
        return null;
    }
}
