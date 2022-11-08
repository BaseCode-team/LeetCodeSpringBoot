package study.team.leetcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-08 18:38
 * @description 应用启动类
 */
@SpringBootApplication(scanBasePackages = {"study.team.leetcode", "com.alibaba.cola"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
