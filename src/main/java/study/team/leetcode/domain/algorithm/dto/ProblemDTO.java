package study.team.leetcode.domain.algorithm.dto;

import lombok.Data;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-04 14:26
 * @description 力扣问题数据传输实体
 */
@Data
public class ProblemDTO {
    /**
     * 力扣题目标题
     */
    private String name;
    /**
     * 力扣题目时间
     */
    private String date;
    /**
     * 力扣题目描述
     */
    private String description;
    /**
     * 力扣题目通过率
     */
    private String passRate;
    /**
     * 力扣题目等级
     */
    private String level;
}
