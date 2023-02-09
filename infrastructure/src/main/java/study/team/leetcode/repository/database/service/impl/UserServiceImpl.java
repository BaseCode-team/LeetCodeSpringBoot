package study.team.leetcode.repository.database.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import study.team.leetcode.dto.query.UserListQry;
import study.team.leetcode.repository.database.UserMapper;
import study.team.leetcode.repository.database.po.UserPO;
import study.team.leetcode.repository.database.service.UserService;

/**
 * @author JiaHao
 * @description 针对表【user(用户表)】的数据库操作Service实现
 * @createDate 2022-11-22 11:19:36
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO>
        implements UserService {

    /**
     * @param qry 查询命令
     * @return Page<UserPO>
     */
    @Override
    public Page<UserPO> selectByPage(UserListQry qry) {
        QueryWrapper<UserPO> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderBy(StringUtils.checkValNotNull(qry.getOrderBy()), "ASC".equals(qry.getOrderDirection()), qry.getOrderBy())
                .groupBy(StringUtils.checkValNotNull(qry.getGroupBy()), qry.getGroupBy())
                .lambda()
                .like(StringUtils.checkValNotNull(qry.getUserName()), UserPO::getUserName, qry.getUserName())
                .like(StringUtils.checkValNotNull(qry.getRealName()), UserPO::getRealName, qry.getRealName())
                .like(StringUtils.checkValNotNull(qry.getPhone()), UserPO::getPhone, qry.getPhone());
        Page<UserPO> page = new Page<>(qry.getPageIndex(), qry.getPageSize());
        return this.page(page, queryWrapper);
    }
}




