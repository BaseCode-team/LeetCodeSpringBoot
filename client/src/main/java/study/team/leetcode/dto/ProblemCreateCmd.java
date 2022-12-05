package study.team.leetcode.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;

/**
 * Problem新增命令
 *
 * @author JiaHao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "ProblemCreateCmd", description = "新增力扣问题需要提供的数据")
public class ProblemCreateCmd extends CommonCommand {
    private LeetCodeProblemCO leetCodeProblemCO;

}