package study.team.leetcode.repository.database.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.po.BaseUuidEntity;

/**
 * 力扣题目
 *
 * @author JiaHao
 * @TableName leet_code_problem
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "leet_code_problem")
@Data
public class LeetCodeProblemPO extends BaseUuidEntity {

    /**
     * 题目编号
     */
    @TableField(value = "no")
    private String no;

    /**
     * 题目标题
     */
    @TableField(value = "name")
    private String name;

    /**
     * 题目描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 题目通过率
     */
    @TableField(value = "pass_rate")
    private String passRate;

    /**
     * 题目难度等级
     */
    @TableField(value = "level")
    private String level;

}