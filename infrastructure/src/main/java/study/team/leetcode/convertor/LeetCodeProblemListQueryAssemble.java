package study.team.leetcode.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import study.team.leetcode.dto.query.LeetCodeProblemListQuery;
import study.team.leetcode.repository.database.po.LeetCodeProblemPO;

/**
 * @author JiaHao
 */
@Mapper(componentModel = "spring")
public interface LeetCodeProblemListQueryAssemble {
    LeetCodeProblemListQueryAssemble INSTANCE = Mappers.getMapper(LeetCodeProblemListQueryAssemble.class);
    //todo 转换passRate

    /**
     * 将query类转换成DO（database object)
     *
     * @param qry 待转换的query类
     * @return study.team.leetcode.repository.database.po.LeetCodeProblemDO
     * @author JiaHao
     * @methodName convert
     * @date 2022/11/9 15:43
     **/
    LeetCodeProblemPO toDO(LeetCodeProblemListQuery qry);
}
