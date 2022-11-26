package study.team.leetcode.repository.database.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.po.BaseUuidEntity;

/**
 * 力扣题解
 *
 * @author JiaHao
 * @TableName leet_code_solution
 */
@EqualsAndHashCode(callSuper = false)
@TableName(value = "leet_code_solution")
@Data
public class LeetCodeSolutionPO extends BaseUuidEntity {

    /**
     * 题目id
     */
    @TableField(value = "problem_id")
    private String problemId;

    /**
     * 解题代码
     */
    @TableField(value = "problem_solution")
    private String problemSolution;

    /**
     * 解题人
     */
    @TableField(value = "solution_author")
    private String solutionAuthor;

}