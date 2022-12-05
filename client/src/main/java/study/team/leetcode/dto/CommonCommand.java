package study.team.leetcode.dto;

import team.study.common.base.model.dto.Command;

/**
 * 整个应用通用的Command
 *
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-09 21:29
 */
public class CommonCommand extends Command {
    private String operator;
    private boolean needsOperator = false;

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        needsOperator = true;
    }

    public boolean isNeedsOperator() {
        return needsOperator;
    }
}
