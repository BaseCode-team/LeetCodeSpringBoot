package study.team.leetcode.dto;

import lombok.Data;
import study.team.leetcode.dto.data.LeetCodeProblemDTO;

/**
 * 力扣题目
 *
 * @author JiaHao
 */
@Data
public class ProblemAddCmd {
    private LeetCodeProblemDTO leetCodeProblemDTO;

}