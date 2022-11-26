package study.team.leetcode.share.event;

/**
 * 领域事件发布接口
 *
 * @author JiaHao
 */
public interface DomainEventPublisher {

    /**
     * 发布事件
     *
     * @param event event
     */
    <EVENT extends BaseDomainEvent> void publish(EVENT event);

    /**
     * 发布事件并保存
     *
     * @param event event
     */
    <EVENT extends BaseDomainEvent> void publishAndSave(EVENT event);

}
