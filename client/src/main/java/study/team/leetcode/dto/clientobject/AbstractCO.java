package study.team.leetcode.dto.clientobject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import team.study.common.base.exception.ValidGroup;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;

/**
 * CO基类
 *
 * @author JiaHao
 * @date 2022-11-22 17:24
 */
@Data
public class AbstractCO {
    @ApiModelProperty(value = "id", name = "id", dataType = "Long")
    @Null(groups = ValidGroup.Create.class)
    @NotNull(groups = ValidGroup.Update.class, message = "id不能为空")
    private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", name = "createTime", dataType = "Date")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间", name = "updateTime", dataType = "Date")
    private Date updateTime;

}
