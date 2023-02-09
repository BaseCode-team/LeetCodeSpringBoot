package study.team.leetcode.commond.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.team.leetcode.convertor.LeetCodeProblemAssemble;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import study.team.leetcode.repository.database.po.LeetCodeProblemPO;
import study.team.leetcode.repository.database.service.LeetCodeProblemService;
import team.study.common.base.response.PageResponse;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 19:37
 * @description 力扣题目查询执行器
 */
@Component
@Slf4j
public class LeetCodeProblemQueryExe {

    private final LeetCodeProblemService service;

    public LeetCodeProblemQueryExe(LeetCodeProblemService service) {
        this.service = service;
    }


    public PageResponse<LeetCodeProblemCO> execute(LeetCodeProblemListQuery cmd) {
        Page<LeetCodeProblemPO> result = service.selectByPage(cmd);
        return PageResponse.of(LeetCodeProblemAssemble.INSTANCE.toDTOList(result.getRecords()), (int) result.getTotal(), (int) result.getSize(), (int) result.getCurrent());
    }
}
