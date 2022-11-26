package study.team.leetcode.commond.user;

import org.springframework.stereotype.Service;
import study.team.leetcode.dto.UserDeleteCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;

/**
 * 删除用户能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:41
 */
@Service
public class UserDeleteAbility extends BaseAbility<UserDeleteCmd, Void> {
    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(UserDeleteCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return
     */
    @Override
    public Response checkIdempotent(UserDeleteCmd abilityCmd) {
        return null;
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(UserDeleteCmd abilityCmd) {
        return null;
    }
}
