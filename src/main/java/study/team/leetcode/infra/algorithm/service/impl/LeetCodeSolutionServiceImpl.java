package study.team.leetcode.infra.algorithm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import study.team.leetcode.infra.algorithm.po.LeetCodeSolution;
import study.team.leetcode.infra.algorithm.service.LeetCodeSolutionService;
import study.team.leetcode.infra.algorithm.mapper.LeetCodeSolutionMapper;
import org.springframework.stereotype.Service;

/**
* @author JiaHao
* @description 针对表【leet_code_solution(力扣题解)】的数据库操作Service实现
* @createDate 2022-11-04 16:24:09
*/
@Service
public class LeetCodeSolutionServiceImpl extends ServiceImpl<LeetCodeSolutionMapper, LeetCodeSolution>
    implements LeetCodeSolutionService{

}




