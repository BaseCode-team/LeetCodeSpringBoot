package study.team.leetcode.aggregate.user.event;

import cn.hutool.core.lang.UUID;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.share.event.BaseDomainEvent;
import study.team.leetcode.share.event.DomainEventEnum;
import study.team.leetcode.share.event.EventStatusEnum;

import java.time.LocalDateTime;

/**
 * 用户新增领域事件
 *
 * @author JiaHao
 */
public class UserCreateEvent extends BaseDomainEvent<User> {

    public UserCreateEvent(User user) {
        super(String.valueOf(user.getId()),
                //仅做演示，领域事件id为防止重复建议自定义雪花id
                UUID.fastUUID().toString(),
                DomainEventEnum.USER_UPDATE,
                EventStatusEnum.PENDING,
                LocalDateTime.now(),
                user
        );
    }

}
