package study.team.leetcode.application.algorithm.queryDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-05 14:46
 * @description 力扣问题查询DTO
 */
@Data
@ApiModel(value = "LeetCodeProblemQueryDTO", description = "前端发送的需要查询的条件")
public class LeetCodeProblemQueryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 题目id
     */
    @ApiModelProperty(value = "题目id",name = "id",dataType = "int")
    private Integer id;

    /**
     * 题目编号
     */
    @ApiModelProperty(value = "题目编号",name = "no",dataType = "int")
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
