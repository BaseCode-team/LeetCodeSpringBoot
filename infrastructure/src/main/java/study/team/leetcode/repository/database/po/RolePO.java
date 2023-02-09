package study.team.leetcode.repository.database.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.po.BaseUuidEntity;

/**
 * 角色表
 *
 * @author JiaHao
 * @TableName role
 */
@TableName(value = "role")
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePO extends BaseUuidEntity {

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色code
     */
    private String code;

}