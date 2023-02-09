package study.team.leetcode.aggregate.user.event;

import cn.hutool.core.lang.UUID;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.share.event.BaseDomainEvent;
import study.team.leetcode.share.event.DomainEventEnum;
import study.team.leetcode.share.event.EventStatusEnum;

import java.time.LocalDateTime;

/**
 * 用户修改领域事件
 *
 * @author JiaHao
 */
public class UserUpdateEvent extends BaseDomainEvent<User> {

    public UserUpdateEvent(User user) {
        super(String.valueOf(user),
                //仅做演示，领域事件id为防止重复建议自定义雪花id
                UUID.fastUUID().toString(),
                DomainEventEnum.USER_UPDATE,
                EventStatusEnum.PENDING,
                LocalDateTime.now(),
                user
        );
    }
}
