package study.team.leetcode.aggregate.role.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import team.study.common.base.model.ddd.AggregateRoot;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 角色聚合根
 *
 * @author JiaHao
 */
@Data
@AllArgsConstructor
@Builder
public class Role implements AggregateRoot {

    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色code
     */
    private String code;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;


    /**
     * 获取用户角色标签
     *
     * @return Boolean
     */
    public Boolean isAdmin() {
        //此处省略100行代码
        return Objects.equals(this.code, "admin");
    }

}
