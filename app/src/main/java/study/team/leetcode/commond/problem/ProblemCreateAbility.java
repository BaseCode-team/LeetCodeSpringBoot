package study.team.leetcode.commond.problem;

import org.springframework.stereotype.Service;
import study.team.leetcode.dto.ProblemCreateCmd;
import study.team.leetcode.share.BaseAbility;
import team.study.common.base.response.Response;

/**
 * 创建力扣问题能力
 *
 * @author JiaHao
 * @date 2022-11-26 09:55
 */
@Service
public class ProblemCreateAbility extends BaseAbility<ProblemCreateCmd, Void> {
    /**
     * @param abilityCmd abilityCmd
     */
    @Override
    public void checkHandler(ProblemCreateCmd abilityCmd) {

    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response checkIdempotent(ProblemCreateCmd abilityCmd) {
        return null;
    }

    /**
     * @param abilityCmd abilityCmd
     * @return Response
     */
    @Override
    public Response execute(ProblemCreateCmd abilityCmd) {
        return null;
    }
}
