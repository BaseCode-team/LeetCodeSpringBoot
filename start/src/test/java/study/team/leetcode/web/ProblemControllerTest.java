package study.team.leetcode.web;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import study.team.leetcode.Application;
import study.team.leetcode.dto.clientobject.UserCO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
class ProblemControllerTest {
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void problemList() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/problem")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalCount").value("2"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void addProblem() {
    }

    @Test
    void addSolution() {

    }

    /**
     * 测试查询用户
     *
     * @author JiaHao
     * @date 2022/11/23 20:05
     **/
    @Test
    void userList() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/user")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 测试添加用户
     * 添加@Transactional 注解自动回滚数据库防止污染
     *
     * @author JiaHao
     * @date 2022/11/23 20:04
     **/
    @Test
    @Transactional
    void addUser() throws Exception {
        UserCO userCO = new UserCO();
        userCO.setUserName("小明");
        userCO.setRealName("明明");
        userCO.setPassword("123456789");
        userCO.setPhone("13100000000");
        userCO.setProvince("湖北");
        userCO.setCity("武汉");
        userCO.setCounty("硚口");
        userCO.setRoleIds("1,3,5");
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/user")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JSONObject.toJSONString(userCO)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateUser() {

    }
}