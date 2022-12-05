package study.team.leetcode.repository.database.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.po.BaseUuidEntity;

/**
 * 用户表
 *
 * @author JiaHao
 * @date 2022-11-22 11:00
 */
@TableName(value = "user")
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPO extends BaseUuidEntity {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 关联的角色id列表
     */
    private String roleIds;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String county;
}
