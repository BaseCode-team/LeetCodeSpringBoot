package study.team.leetcode.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.query.PageQuery;

/**
 * 查询用户列表命令
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:14
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "UserListQry", description = "前端发送的需要查询的条件")
public class UserListQry extends PageQuery {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName", dataType = "String")
    private String userName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", name = "realName", dataType = "String")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", name = "phone", dataType = "String")
    private String phone;
}

