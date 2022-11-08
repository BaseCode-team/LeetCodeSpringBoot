package study.team.leetcode.problem.excutor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import study.team.leetcode.LeetCodeProblemListQuery;
import study.team.leetcode.dto.data.LeetCodeProblemDTO;
import study.team.leetcode.problem.assemble.LeetCodeProblemAssemble;
import study.team.leetcode.problem.po.LeetCodeProblemDO;
import study.team.leetcode.problem.service.LeetCodeProblemService;

import java.util.List;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 19:37
 * @description 力扣题目查询执行器
 */
@Component
@Slf4j
public class LeetCodeProblemListQueryExe {

    private final ConversionService conversionService;
    private final LeetCodeProblemService service;

    public LeetCodeProblemListQueryExe(ConversionService conversionService, LeetCodeProblemService service) {
        this.conversionService = conversionService;
        this.service = service;
    }


    public MultiResponse<LeetCodeProblemDTO> execute(LeetCodeProblemListQuery cmd) {
        LambdaQueryWrapper<LeetCodeProblemDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.checkValNotNull(cmd.getId()), LeetCodeProblemDO::getId, cmd.getId())
                .eq(StringUtils.checkValNotNull(cmd.getNo()), LeetCodeProblemDO::getNo, cmd.getNo())
                .like(StringUtils.checkValNotNull(cmd.getName()), LeetCodeProblemDO::getName, cmd.getName())
                .like(StringUtils.checkValNotNull(cmd.getDescription()), LeetCodeProblemDO::getDescription, cmd.getDescription())
                .eq(StringUtils.checkValNotNull(cmd.getLevel()), LeetCodeProblemDO::getLevel, cmd.getLevel())
                .eq(StringUtils.checkValNotNull(cmd.getCreateTime()), LeetCodeProblemDO::getCreateTime, cmd.getCreateTime());
        log.info("查询信息: {}", cmd);
        List<LeetCodeProblemDO> result = service.list(queryWrapper);
        return MultiResponse.of(LeetCodeProblemAssemble.INSTANCE.toVOList(result));
    }
}
