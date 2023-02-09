package study.team.leetcode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import study.team.leetcode.dto.clientobject.UserCO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * User新增命令
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:15
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserCreateCmd extends CommonCommand {
    @NotNull(message = "创建信息不能为空")
    @Valid
    private UserCO userCO;
}
