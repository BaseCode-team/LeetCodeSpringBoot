package study.team.leetcode.repository.database.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import study.team.leetcode.repository.database.LeetCodeSolutionMapper;
import study.team.leetcode.repository.database.po.LeetCodeSolutionPO;
import study.team.leetcode.repository.database.service.LeetCodeSolutionService;

/**
 * @author JiaHao
 * @description 针对表【leet_code_solution(力扣题解)】的数据库操作Service实现
 * @createDate 2022-11-04 16:24:09
 */
@Service
public class LeetCodeSolutionServiceImpl extends ServiceImpl<LeetCodeSolutionMapper, LeetCodeSolutionPO>
        implements LeetCodeSolutionService {

}




