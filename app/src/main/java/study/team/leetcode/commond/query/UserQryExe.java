package study.team.leetcode.commond.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Component;
import study.team.leetcode.convertor.UserAssemble;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.dto.query.UserQry;
import study.team.leetcode.repository.database.po.UserPO;
import study.team.leetcode.repository.database.service.UserService;
import team.study.common.base.response.PageResponse;
import team.study.common.base.response.Response;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-10 08:24
 * @description UserProfile单个查询执行器
 */
@Component
public class UserQryExe {
    private final UserService service;

    public UserQryExe(UserService service) {
        this.service = service;
    }

    public Response execute(UserQry qry) {

        return null;
    }

    public Response execute(UserListQry cmd) {
        Page<UserPO> result = service.selectByPage(cmd);
        return PageResponse.of(UserAssemble.INSTANCE.toDTOList(result.getRecords()), (int) result.getTotal(), (int) result.getSize(), (int) result.getCurrent());
    }
}
