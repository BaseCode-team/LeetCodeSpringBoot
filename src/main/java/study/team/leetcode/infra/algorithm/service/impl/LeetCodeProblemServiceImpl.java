package study.team.leetcode.infra.algorithm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import study.team.leetcode.infra.algorithm.po.LeetCodeProblem;
import study.team.leetcode.infra.algorithm.mapper.LeetCodeProblemMapper;
import study.team.leetcode.infra.algorithm.service.LeetCodeProblemService;
import org.springframework.stereotype.Service;

/**
* @author JiaHao
* @description 针对表【leet_code_problem(力扣题目)】的数据库操作Service实现
* @createDate 2022-11-04 16:20:26
*/
@Service
public class LeetCodeProblemServiceImpl extends ServiceImpl<LeetCodeProblemMapper, LeetCodeProblem>
    implements LeetCodeProblemService{

}




