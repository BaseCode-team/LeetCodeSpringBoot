package study.team.leetcode.aggregate.solution;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 18:13
 * @description 力扣题解
 */
@Data
@ApiModel(value = "LeetCodeSolution", description = "力扣题解实体类")
public class LeetCodeSolution {
    /**
     * 题解id
     */
    private Integer id;

    /**
     * 题目id
     */
    private String problemId;

    /**
     * 解题代码
     */
    private String problemSolution;

    /**
     * 解题人
     */
    private String solutionAuthor;

    /**
     * 首次提交解题时间
     */
    private Date createTime;

    /**
     * 更新答案时间
     */
    private Date updateTime;
}
