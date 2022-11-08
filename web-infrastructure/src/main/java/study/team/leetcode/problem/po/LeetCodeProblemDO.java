package study.team.leetcode.problem.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 力扣题目
 *
 * @author JiaHao
 * @TableName leet_code_problem
 */
@TableName(value = "leet_code_problem")
@Data
public class LeetCodeProblemDO implements Serializable {
    /**
     * 题目id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目编号
     */
    @TableField(value = "no")
    private Integer no;

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
    private Integer level;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}