package study.team.leetcode.dto.clientobject;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 题解CO
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 09:04
 * @description 题解DTO
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "LeetCodeSolutionCO", description = "后端即将返回前端的数据")
public class LeetCodeSolutionCO extends AbstractCO {
}
