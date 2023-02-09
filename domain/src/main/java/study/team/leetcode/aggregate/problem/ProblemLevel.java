package study.team.leetcode.aggregate.problem;

/**
 * @author JiaHao
 */

public enum ProblemLevel {
    /**
     * 题目难度等级
     *
     * @date 2022/11/10 18:19
     **/
    LEVEL_EASY("简单", "easy"),
    LEVEL_MEDIUM("中等", "medium"),
    LEVEL_HARD("困难", "hard");
    private final String name;
    private final String code;

    ProblemLevel(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
