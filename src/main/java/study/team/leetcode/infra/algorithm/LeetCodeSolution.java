package study.team.leetcode.infra.algorithm;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 力扣题解
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
    private Integer problem_id;

    /**
     * 解题代码
     */
    @TableField(value = "problem_solution")
    private String problem_solution;

    /**
     * 解题人
     */
    @TableField(value = "solution_author")
    private String solution_author;

    /**
     * 首次提交解题时间
     */
    @TableField(value = "create_time")
    private Date create_time;

    /**
     * 更新答案时间
     */
    @TableField(value = "update_time")
    private Date update_time;

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
            && (this.getProblem_id() == null ? other.getProblem_id() == null : this.getProblem_id().equals(other.getProblem_id()))
            && (this.getProblem_solution() == null ? other.getProblem_solution() == null : this.getProblem_solution().equals(other.getProblem_solution()))
            && (this.getSolution_author() == null ? other.getSolution_author() == null : this.getSolution_author().equals(other.getSolution_author()))
            && (this.getCreate_time() == null ? other.getCreate_time() == null : this.getCreate_time().equals(other.getCreate_time()))
            && (this.getUpdate_time() == null ? other.getUpdate_time() == null : this.getUpdate_time().equals(other.getUpdate_time()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProblem_id() == null) ? 0 : getProblem_id().hashCode());
        result = prime * result + ((getProblem_solution() == null) ? 0 : getProblem_solution().hashCode());
        result = prime * result + ((getSolution_author() == null) ? 0 : getSolution_author().hashCode());
        result = prime * result + ((getCreate_time() == null) ? 0 : getCreate_time().hashCode());
        result = prime * result + ((getUpdate_time() == null) ? 0 : getUpdate_time().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", problem_id=").append(problem_id);
        sb.append(", problem_solution=").append(problem_solution);
        sb.append(", solution_author=").append(solution_author);
        sb.append(", create_time=").append(create_time);
        sb.append(", update_time=").append(update_time);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}