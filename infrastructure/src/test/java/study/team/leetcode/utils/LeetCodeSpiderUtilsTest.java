package study.team.leetcode.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeetCodeSpiderUtilsTest {
    private final LeetCodeSpiderUtils utils = new LeetCodeSpiderUtils();
    private JSONObject jsonObject;

    @BeforeEach
    void init() {
        jsonObject = utils.getProblemByName("two-sum");
    }

    @Test
    void toDTO() {
        System.out.println(utils.toDTO(jsonObject).toString());
    }
}