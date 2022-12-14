package study.team.leetcode.infra.algorithm.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.team.leetcode.infra.algorithm.po.LeetCodeSolution;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author JiaHao
* @description 针对表【leet_code_solution(力扣题解)】的数据库操作Mapper
* @createDate 2022-11-04 16:24:08
* @Entity study.team.leetcode.infra.algorithm.po.LeetCodeSolution
*/
@Mapper
public interface LeetCodeSolutionMapper extends BaseMapper<LeetCodeSolution> {

}




