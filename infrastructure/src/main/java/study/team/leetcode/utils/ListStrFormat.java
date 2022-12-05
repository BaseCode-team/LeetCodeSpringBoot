package study.team.leetcode.utils;

import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Component;
import study.team.leetcode.aggregate.user.modal.Role;

import java.util.List;
import java.util.stream.Collectors;

/**
 * List和String相互转换
 *
 * @author JiaHao
 * @date 2022-11-23 13:37
 */
@Component
public class ListStrFormat {
    public static String toStr(List<Role> list) {
        return CollUtil.join(list.stream().map(Role::getId).collect(Collectors.toList()), ",");
    }

}
