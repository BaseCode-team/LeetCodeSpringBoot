package study.team.leetcode.dto.clientobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 力扣问题CO
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-06 21:12
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "LeetCodeProblemCO", description = "后端即将返回前端的数据")
public class LeetCodeProblemCO extends AbstractCO {
    private static final long serialVersionUID = 1L;
    /**
     * 题目编号
     */
    @ApiModelProperty(value = "题目编号", name = "no", dataType = "String")
    private String no;

    /**
     * 题目标题
     */
    @ApiModelProperty(value = "题目标题", name = "name", dataType = "String")
    private String name;

    /**
     * 题目描述
     */
    @ApiModelProperty(value = "题目描述", name = "description", dataType = "String")
    private String description;

    /**
     * 题目难度等级
     */
    @ApiModelProperty(value = "题目难度等级", name = "level", dataType = "String")
    private String level;

}
