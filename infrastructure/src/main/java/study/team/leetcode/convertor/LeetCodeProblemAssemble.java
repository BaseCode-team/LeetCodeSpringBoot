package study.team.leetcode.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.team.leetcode.aggregate.problem.LeetCodeProblem;
import study.team.leetcode.dto.clientobject.LeetCodeProblemCO;
import study.team.leetcode.repository.database.po.LeetCodeProblemPO;

import java.util.List;

/**
 * @author JiaHao
 */
@Mapper(componentModel = "spring")
public interface LeetCodeProblemAssemble {
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

    LeetCodeProblem toDTO(LeetCodeProblemPO po);
    //todo 转换ownerId

    /**
     * 将List<LeetCodeProblem>转换为List<LeetCodeProblemVO>
     *
     * @param poList - List<LeetCodeProblem>
     * @return java.util.List<study.team.leetcode.application.algorithm.vo.LeetCodeProblemVO>
     * @author JiaHao
     * @methodName toVOList
     * @date 2022/11/6 21:49
     **/
    List<LeetCodeProblemCO> toDTOList(List<LeetCodeProblemPO> poList);


}
