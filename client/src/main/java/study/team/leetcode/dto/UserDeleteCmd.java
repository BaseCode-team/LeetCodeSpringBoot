package study.team.leetcode.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * User删除命令
 *
 * @author JiaHao
 * @date 2022-11-24 20:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserDeleteCmd extends CommonCommand {
    private Long id;
}
