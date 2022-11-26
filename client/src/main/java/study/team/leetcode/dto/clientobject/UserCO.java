package study.team.leetcode.dto.clientobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.exception.ValidGroup;

import javax.validation.constraints.NotBlank;

/**
 * 用户CO
 *
 * @author JiaHao
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "UserCO", description = "后端即将返回前端的数据")
public class UserCO extends AbstractCO {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String")
    @NotBlank(groups = ValidGroup.Create.class, message = "用户名不能为空")
    private String userName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", name = "realName", dataType = "String")
    @NotBlank(groups = ValidGroup.Create.class, message = "真实姓名不能为空")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "phone", dataType = "String")
    @NotBlank(groups = ValidGroup.Create.class, message = "手机号不能为空")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", dataType = "String")
    private String password;

    /**
     * 关联的角色id列表
     */
    @ApiModelProperty(value = "关联的角色id列表", name = "roleIds", dataType = "String")
    @NotBlank(groups = ValidGroup.Create.class, message = "角色id列表不能为空")
    private String roleIds;

    /**
     * 省
     */
    @ApiModelProperty(value = "省", name = "province", dataType = "String")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty(value = "市", name = "city", dataType = "String")
    private String city;

    /**
     * 区
     */
    @ApiModelProperty(value = "区", name = "county", dataType = "String")
    private String county;

}
