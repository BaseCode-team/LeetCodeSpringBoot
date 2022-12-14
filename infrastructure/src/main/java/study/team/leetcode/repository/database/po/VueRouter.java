package study.team.leetcode.repository.database.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.po.TreeEntity;

import java.io.Serial;

/**
 * vue路由实体类
 *
 * @author JiaHao
 * @date 2022-12-13 22:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VueRouter extends TreeEntity<VueRouter> {
    @Serial
    private static final long serialVersionUID = -3327478146308500708L;
    @ApiModelProperty(value = "路径")
    private String path;
    @ApiModelProperty(value = "菜单名称")
    private String name;
    @ApiModelProperty(value = "组件")
    private String component;
    @ApiModelProperty(value = "重定向")
    private String redirect;
    @ApiModelProperty(value = "元数据")
    private RouterMeta meta;

    @Override
    @JsonIgnore
    public Long getParentId() {
        return this.parentId;
    }

    public Boolean getAlwaysShow() {
        return getChildren() != null && !getChildren().isEmpty();
    }

//    public String getComponent() {
//        if (getChildren() != null && !getChildren().isEmpty()) {
//            return "Layout";
//        }
//        return this.component;
//    }
}
