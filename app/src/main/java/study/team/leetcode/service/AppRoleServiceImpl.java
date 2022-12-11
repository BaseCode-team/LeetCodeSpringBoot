package study.team.leetcode.service;

import org.springframework.stereotype.Service;
import study.team.leetcode.api.RoleServiceI;
import study.team.leetcode.repository.database.service.RoleService;
import team.study.common.base.response.MultiResponse;
import team.study.common.base.response.Response;

/**
 * 角色接口实现类
 *
 * @author JiaHao
 * @date 2022-12-11 15:41
 */
@Service
public class AppRoleServiceImpl implements RoleServiceI {
    private final RoleService service;

    public AppRoleServiceImpl(RoleService service) {
        this.service = service;
    }

    /**
     * @return Response
     */
    @Override
    public Response getRoles() {
        return MultiResponse.of(service.list());
    }
}
