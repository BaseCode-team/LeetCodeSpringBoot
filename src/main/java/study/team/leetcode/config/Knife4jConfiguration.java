package study.team.leetcode.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-06-26 18:07
 * @description Configuration of Knife4j
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket=new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("# swagger-bootstrap-ui-demo Restful APIs")
                        .termsOfServiceUrl("https://www.jhlearn.com/")
                        .contact(new Contact("陈家豪","www.jhlearn.top","408897865@qq.com"))
                        .version("1.0")
                        .build())
                // 分组名称
                .groupName("1.X版本")
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("study.team.leetcode.application.algorithm.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
