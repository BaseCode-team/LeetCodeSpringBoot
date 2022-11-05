package study.team.leetcode.infra.algorithm.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 力扣题解
 * @author JiaHao
 * @TableName leet_code_solution
 */
@TableName(value ="leet_code_solution")
@Data
public class LeetCodeSolution implements Serializable {
    /**
     * 题解id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 题目id
     */
    @TableField(value = "problem_id")
    private Integer problemId;

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

    /**
     * 首次提交解题时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新答案时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LeetCodeSolution other = (LeetCodeSolution) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProblemId() == null ? other.getProblemId() == null : this.getProblemId().equals(other.getProblemId()))
            && (this.getProblemSolution() == null ? other.getProblemSolution() == null : this.getProblemSolution().equals(other.getProblemSolution()))
            && (this.getSolutionAuthor() == null ? other.getSolutionAuthor() == null : this.getSolutionAuthor().equals(other.getSolutionAuthor()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProblemId() == null) ? 0 : getProblemId().hashCode());
        result = prime * result + ((getProblemSolution() == null) ? 0 : getProblemSolution().hashCode());
        result = prime * result + ((getSolutionAuthor() == null) ? 0 : getSolutionAuthor().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", problemId=").append(problemId);
        sb.append(", problemSolution=").append(problemSolution);
        sb.append(", solutionAuthor=").append(solutionAuthor);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}