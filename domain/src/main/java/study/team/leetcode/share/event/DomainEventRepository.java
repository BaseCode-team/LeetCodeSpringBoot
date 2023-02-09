package study.team.leetcode.share.event;

import java.util.List;

/**
 * 领域事件仓储，保存已发生的领域事件，用于事件溯源
 *
 * @author JiaHao
 */
public interface DomainEventRepository {

    /**
     * 按id查找
     *
     * @param id 唯一标识
     * @return 聚合
     */
    BaseDomainEvent load(Long id);

    /**
     * 按id查找
     *
     * @param domainId 唯一标识
     * @return 聚合
     */
    List<BaseDomainEvent> loadByDomainId(String domainId);

    /**
     * 保存
     *
     * @param baseDomainEvent 领域事件
     */
    void save(BaseDomainEvent baseDomainEvent);

    /**
     * 更新
     *
     * @param baseDomainEvent 领域事件
     */
    void update(BaseDomainEvent baseDomainEvent);

}