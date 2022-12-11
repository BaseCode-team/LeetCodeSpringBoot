package study.team.leetcode.convertor;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import study.team.leetcode.aggregate.user.modal.User;
import study.team.leetcode.dto.clientobject.UserCO;
import study.team.leetcode.repository.database.po.UserPO;
import study.team.leetcode.utils.ListStrFormat;

import java.util.List;

/**
 * @author JiaHao
 */
@Mapper(componentModel = "spring", imports = {ListStrFormat.class, User.class})
public interface UserAssemble {
    UserAssemble INSTANCE = Mappers.getMapper(UserAssemble.class);
    //todo 转换Adress role

    /**
     * 将UserDO转换成领域对象User
     *
     * @param userPO 待转换的DO
     * @return User
     * @author JiaHao
     * @date 2022/11/22 11:33
     * @methodName convert
     **/
    @Mappings({
            @Mapping(source = "province", target = "address.province"),
            @Mapping(source = "city", target = "address.city"),
            @Mapping(source = "county", target = "address.county")
    })
    User toUser(UserPO userPO);
    //todo 转换Adress role deleted

    /**
     * 从User转换为UserDo
     *
     * @author JiaHao
     * @date 2022/11/22 16:30
     **/
    @Mappings({
            @Mapping(source = "address.province", target = "province"),
            @Mapping(source = "address.city", target = "city"),
            @Mapping(source = "address.county", target = "county"),
            @Mapping(target = "roleIds", expression = "java(ListStrFormat.toStr(user.getRoles()))")
    })
    UserPO toUserDO(User user);

    List<UserCO> toDTOList(List<UserPO> records);

    @Mappings({
            @Mapping(source = "province", target = "address.province"),
            @Mapping(source = "city", target = "address.city"),
            @Mapping(source = "county", target = "address.county")
    })
    User toUser(UserCO co);
}
