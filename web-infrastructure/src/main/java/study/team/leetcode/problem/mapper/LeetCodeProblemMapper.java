package study.team.leetcode.problem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import study.team.leetcode.problem.po.LeetCodeProblemDO;

/**
 * @author JiaHao
 * @description 针对表【leet_code_problem(力扣题目)】的数据库操作Mapper
 * @createDate 2022-11-04 16:20:26
 * @Entity study.team.leetcode.infra.po.algorithm.LeetCodeProblem
 */
@Mapper
public interface LeetCodeProblemMapper extends BaseMapper<LeetCodeProblemDO> {

}




