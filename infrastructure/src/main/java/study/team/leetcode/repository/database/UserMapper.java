package study.team.leetcode.repository.database;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import study.team.leetcode.repository.database.po.UserPO;

/**
 * @author JiaHao
 * @description 针对表【user(用户表)】的数据库操作Mapper
 * @createDate 2022-11-22 11:19:36
 * @Entity study.team.leetcode.repository.database.po.UserPO
 */
@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}




