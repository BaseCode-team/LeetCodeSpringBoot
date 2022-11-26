package study.team.leetcode.aggregate.problem;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import team.study.common.base.exception.BizException;

import java.util.Date;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-06 21:12
 * @description 力扣问题VO
 */
@Data
@ApiModel(value = "LeetCodeProblem", description = "力扣问题实体类")
public class LeetCodeProblem {
    /**
     * 题目id
     */
    @ApiModelProperty(value = "题目id", name = "id", dataType = "int")
    private Integer id;

    /**
     * 题目编号
     */
    @ApiModelProperty(value = "题目编号", name = "no", dataType = "int")
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
    private ProblemLevel level;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime", dataType = "datetime")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", name = "updateTime", dataType = "datetime")
    private Date updateTime;

    public void setLevel(String level) {
        switch (level) {
            case "easy" -> this.level = ProblemLevel.LEVEL_EASY;
            case "medium" -> this.level = ProblemLevel.LEVEL_MEDIUM;
            case "hard" -> this.level = ProblemLevel.LEVEL_HARD;
            default -> throw new BizException("找不到此难度类型");
        }
    }
}
