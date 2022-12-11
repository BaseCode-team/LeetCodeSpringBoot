package study.team.leetcode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import study.team.leetcode.dto.clientobject.UserCO;

/**
 * 用户登录命令
 *
 * @author JiaHao
 * @date 2022-12-11 14:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserLoginCmd extends CommonCommand {
    private UserCO userCO;
}
