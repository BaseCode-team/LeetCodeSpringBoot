package study.team.leetcode.repository.database.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import study.team.leetcode.repository.database.po.LeetCodeProblemPO;

/**
 * @author JiaHao
 * @description 针对表【leet_code_problem(力扣题目)】的数据库操作Service
 * @createDate 2022-11-04 16:20:26
 */
public interface LeetCodeProblemService extends IService<LeetCodeProblemPO> {
    /**
     * 分页查询
     *
     * @param qry 查询条件
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page<study.team.leetcode.repository.database.po.LeetCodeProblemDO>
     * @author JiaHao
     * @methodName selectByPage
     * @date 2022/11/9 15:13
     **/
    Page<LeetCodeProblemPO> selectByPage(LeetCodeProblemListQuery qry);
}
