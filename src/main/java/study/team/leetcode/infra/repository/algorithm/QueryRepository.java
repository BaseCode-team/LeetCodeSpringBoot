package study.team.leetcode.infra.repository.algorithm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.team.leetcode.application.algorithm.queryDTO.LeetCodeProblemQueryDTO;
import study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO;
import study.team.leetcode.infra.algorithm.assmble.LeetCodeProblemAssmble;
import study.team.leetcode.infra.algorithm.po.LeetCodeProblem;
import study.team.leetcode.infra.algorithm.service.LeetCodeProblemService;

import java.util.List;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-05 14:41
 * @description 查询repository
 */
@Service
@Slf4j
public class QueryRepository {
    private final LeetCodeProblemService service;

    public QueryRepository(LeetCodeProblemService service){
        this.service = service;
    }

    public LeetCodeProblemVO queryOne(LeetCodeProblemQueryDTO dto) {
        LambdaQueryWrapper<LeetCodeProblem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.checkValNotNull(dto.getId()), LeetCodeProblem::getId, dto.getId())
                .eq(StringUtils.checkValNotNull(dto.getNo()), LeetCodeProblem::getNo, dto.getNo())
                .eq(StringUtils.checkValNotNull(dto.getName()), LeetCodeProblem::getName, dto.getName())
                .eq(StringUtils.checkValNotNull(dto.getLevel()), LeetCodeProblem::getLevel, dto.getLevel())
                .eq(StringUtils.checkValNotNull(dto.getCreateTime()), LeetCodeProblem::getCreateTime, dto.getCreateTime());
        log.info("查询信息: {}", dto);
        return LeetCodeProblemAssmble.INSTANCE.toVO(service.getOne(queryWrapper));
    }

    public List<LeetCodeProblemVO> queryList(LeetCodeProblemQueryDTO dto) {
        LambdaQueryWrapper<LeetCodeProblem> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.checkValNotNull(dto.getId()), LeetCodeProblem::getId, dto.getId())
                .eq(StringUtils.checkValNotNull(dto.getNo()), LeetCodeProblem::getNo, dto.getNo())
                .like(StringUtils.checkValNotNull(dto.getName()), LeetCodeProblem::getName, dto.getName())
                .like(StringUtils.checkValNotNull(dto.getDescription()), LeetCodeProblem::getDescription, dto.getDescription())
                .eq(StringUtils.checkValNotNull(dto.getLevel()), LeetCodeProblem::getLevel, dto.getLevel())
                .eq(StringUtils.checkValNotNull(dto.getCreateTime()), LeetCodeProblem::getCreateTime, dto.getCreateTime());
        log.info("查询信息: {}", dto);
        return LeetCodeProblemAssmble.INSTANCE.toVOList(service.list(queryWrapper));
    }
}
