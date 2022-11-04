package study.team.leetcode.domain.algorithm.entity.spider;

import lombok.Data;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-06-29 21:19
 * @description 力扣题目信息
 */
@Data
public class Problem {
    private String name;
    private String date;
    private String description;
    private String passRate;
    private String level;
}
