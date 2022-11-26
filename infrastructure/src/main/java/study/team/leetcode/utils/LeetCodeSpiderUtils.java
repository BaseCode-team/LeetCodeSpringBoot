package study.team.leetcode.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.SneakyThrows;
import okhttp3.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import study.team.leetcode.aggregate.problem.LeetCodeProblem;

import java.io.IOException;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-09 09:03
 * @description 力扣问题爬虫
 */
public class LeetCodeSpiderUtils {
    @SneakyThrows(IOException.class)
    public JSONObject getProblemByName(String questionName) {
        String questionUrl = "https://leetcode-cn.com/problems/" + questionName + "/description/";
        String graphqlUrl = "https://leetcode-cn.com/graphql/";
        Connection.Response response = Jsoup.connect(questionUrl)
                .method(Connection.Method.GET)
                .execute();

        String csrftoken = "g2B7f2I2PVERrR160QCgLvdTeX2CY2KWXoiXtsNlNMxrNzSsNA5esgVVrhvx4PZs";
        String cfduid = response.cookie("__cfduid");

        OkHttpClient client = new OkHttpClient.Builder()
                .followRedirects(false)
                .followSslRedirects(false)
                .build();

        String postBody = "query{\n" +
                "  question(titleSlug:\"" + questionName + "\") {\n" +
                "    questionFrontendId\n" +
                "    translatedTitle\n" +
                "    titleSlug\n" +
                "    difficulty\n" +
                "    translatedContent\n" +
                "  }\n" +
                "}\n";

        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/graphql")
                .addHeader("Referer", questionUrl)
                .addHeader("Cookie", "__cfduid=" + cfduid + ";" + "csrftoken=" + csrftoken)
                .addHeader("x-csrftoken", csrftoken)
                .url(graphqlUrl)
                .post(RequestBody.Companion.create(postBody, MediaType.parse("application/graphql; charset=utf-8")))
                .build();
        Response response1 = client.newCall(request).execute();
        assert response1.body() != null;
        return JSONObject.parseObject(response1.body().string());
    }

    public LeetCodeProblem toDTO(JSONObject question) {
        LeetCodeProblem leetCodeProblem = new LeetCodeProblem();
        JSONObject data = (JSONObject) question.get("data");
        JSONObject questionObj = (JSONObject) data.get("question");
        leetCodeProblem.setNo(questionObj.getString("questionFrontendId"));
        leetCodeProblem.setName(questionObj.getString("translatedTitle"));
        leetCodeProblem.setLevel(questionObj.getString("difficulty"));
        leetCodeProblem.setDescription(questionObj.getString("translatedContent"));
        return leetCodeProblem;
    }
}
