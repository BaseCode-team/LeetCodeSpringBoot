package study.team.leetcode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import study.team.leetcode.dto.clientobject.UserCO;

/**
 * User更新命令
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserUpdateCmd extends CommonCommand {

    private UserCO userCO;

}
