package study.team.leetcode.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import study.team.leetcode.dto.clientobject.LeetCodeSolutionCO;

/**
 * Solution新增命令
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 09:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "SolutionCreateCmd", description = "新增力扣题解需要提供的数据")
public class SolutionCreateCmd extends CommonCommand {
    private LeetCodeSolutionCO leetCodeSolutionCO;
}
