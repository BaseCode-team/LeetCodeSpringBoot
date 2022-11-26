package study.team.leetcode.dto.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import team.study.common.base.model.query.PageQuery;

import java.util.Date;

/**
 * 查询力扣问题命令
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-05 14:46
 */
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel(value = "LeetCodeProblemListQuery", description = "前端发送的需要查询的条件")
public class LeetCodeProblemListQuery extends PageQuery {
    /**
     * 题目id
     */
    @ApiModelProperty(value = "题目id", name = "id", dataType = "int")
    private Integer id;

    /**
     * 题目编号
     */
    @ApiModelProperty(value = "题目编号", name = "no", dataType = "int")
    private Integer no;

    /**
     * 题目标题
     */
    @ApiModelProperty(value = "题目标题",name = "name",dataType = "String")
    private String name;

    /**
     * 题目描述
     */
    @ApiModelProperty(value = "题目描述",name = "description",dataType = "String")
    private String description;

    /**
     * 题目难度等级
     */
    @ApiModelProperty(value = "题目难度等级",name = "level",dataType = "int")
    private Integer level;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间",name = "createTime",dataType = "datetime")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间",name = "updateTime",dataType = "datetime")
    private Date updateTime;
}
