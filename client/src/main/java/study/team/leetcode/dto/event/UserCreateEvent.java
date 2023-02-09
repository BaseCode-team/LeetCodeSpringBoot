package study.team.leetcode.dto.event;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户创建事件
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 09:28
 */
@Getter
@Setter
public class UserCreateEvent {
    private String userId;
}
