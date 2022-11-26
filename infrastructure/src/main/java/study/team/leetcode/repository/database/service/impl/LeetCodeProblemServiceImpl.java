package study.team.leetcode.repository.database.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import study.team.leetcode.repository.database.LeetCodeProblemMapper;
import study.team.leetcode.repository.database.po.LeetCodeProblemPO;
import study.team.leetcode.repository.database.service.LeetCodeProblemService;

/**
 * @author JiaHao
 * @description 针对表【leet_code_problem(力扣题目)】的数据库操作Service实现
 * @createDate 2022-11-04 16:20:26
 */
@Service
public class LeetCodeProblemServiceImpl extends ServiceImpl<LeetCodeProblemMapper, LeetCodeProblemPO>
        implements LeetCodeProblemService {
    @Override
    public Page<LeetCodeProblemPO> selectByPage(LeetCodeProblemListQuery qry) {
        QueryWrapper<LeetCodeProblemPO> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderBy(StringUtils.checkValNotNull(qry.getOrderBy()), "ASC".equals(qry.getOrderDirection()), qry.getOrderBy())
                .groupBy(StringUtils.checkValNotNull(qry.getGroupBy()), qry.getGroupBy())
                .lambda()
                .eq(StringUtils.checkValNotNull(qry.getNo()), LeetCodeProblemPO::getNo, qry.getNo())
                .eq(StringUtils.checkValNotNull(qry.getLevel()), LeetCodeProblemPO::getLevel, qry.getLevel())
                .eq(StringUtils.checkValNotNull(qry.getCreateTime()), LeetCodeProblemPO::getCreateTime, qry.getCreateTime())
                .like(StringUtils.checkValNotNull(qry.getName()), LeetCodeProblemPO::getName, qry.getName())
                .like(StringUtils.checkValNotNull(qry.getDescription()), LeetCodeProblemPO::getDescription, qry.getDescription());
        Page<LeetCodeProblemPO> page = new Page<>(qry.getPageIndex(), qry.getPageSize());
        return this.page(page, queryWrapper);
    }
}




