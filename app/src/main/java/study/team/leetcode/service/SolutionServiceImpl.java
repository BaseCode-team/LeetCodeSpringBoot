package study.team.leetcode.service;

import org.springframework.stereotype.Service;
import study.team.leetcode.api.SolutionServiceI;
import study.team.leetcode.dto.SolutionCreateCmd;
import team.study.common.base.response.Response;

/**
 * 力扣题解接口实现类
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 18:47
 */
@Service
public class SolutionServiceImpl implements SolutionServiceI {
    @Override
    public Response addSolution(SolutionCreateCmd cmd) {
        return null;
    }
}
