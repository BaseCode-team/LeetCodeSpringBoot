package study.team.leetcode.infra.algorithm.assmble;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO;
import study.team.leetcode.infra.algorithm.po.LeetCodeProblem;

import java.util.List;

/**
 * @author JiaHao
 */
@Mapper
public interface LeetCodeProblemAssmble {
    LeetCodeProblemAssmble INSTANCE = Mappers.getMapper(LeetCodeProblemAssmble.class);

    /**
     * 将LeetCodeProblem转换为LeetCodeProblemVO
     *
     * @param po - 数据库对应 LeetCodeProblem po
     * @return study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO
     * @author JiaHao
     * @methodName toVO
     * @date 2022/11/6 21:47
     **/
    LeetCodeProblemVO toVO(LeetCodeProblem po);

    /**
     * 将List<LeetCodeProblem>转换为List<LeetCodeProblemVO>
     *
     * @param poList - List<LeetCodeProblem>
     * @return java.util.List<study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO>
     * @author JiaHao
     * @methodName toVOList
     * @date 2022/11/6 21:49
     **/
    List<LeetCodeProblemVO> toVOList(List<LeetCodeProblem> poList);
}
