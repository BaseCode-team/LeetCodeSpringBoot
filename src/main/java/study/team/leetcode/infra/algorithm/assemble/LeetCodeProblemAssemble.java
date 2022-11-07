package study.team.leetcode.infra.algorithm.assemble;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.core.convert.converter.Converter;
import study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO;
import study.team.leetcode.infra.algorithm.po.LeetCodeProblem;

import java.util.List;

/**
 * @author JiaHao
 */
@Mapper(componentModel = "spring")
public interface LeetCodeProblemAssemble extends Converter<LeetCodeProblem, LeetCodeProblemVO> {
    LeetCodeProblemAssemble INSTANCE = Mappers.getMapper(LeetCodeProblemAssemble.class);

    /**
     * 将LeetCodeProblem转换为LeetCodeProblemVO
     *
     * @param po - 数据库对应 LeetCodeProblem po
     * @return study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO
     * @author JiaHao
     * @methodName toVO
     * @date 2022/11/6 21:47
     **/

    @Override
    LeetCodeProblemVO convert(LeetCodeProblem po);

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
