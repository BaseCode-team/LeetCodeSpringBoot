package study.team.leetcode.repository.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import study.team.leetcode.repository.database.po.RolePO;

/**
 * @author JiaHao
 * @description 针对表【role(角色表)】的数据库操作Mapper
 * @createDate 2022-11-22 13:21:31
 * @Entity study.team.leetcode.repository.database.po.RolePO
 */
@Mapper
public interface RoleMapper extends BaseMapper<RolePO> {

}




