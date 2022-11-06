package study.team.leetcode.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-06 20:17
 * @description 我的接口个人信息
 */
@Component
public class MyApiInfo {
    @Value("${knife4j.title}")
    String title;
    @Value("${knife4j.description}")
    String description;
    @Value("${knife4j.termsOfServiceUrl}")
    String termsOfServiceUrl;
    @Value("${knife4j.contact.name}")
    String name;
    @Value("${knife4j.contact.email}")
    String email;
    @Value("${knife4j.contact.url}")
    String url;
    @Value("${knife4j.version}")
    String version;
    @Value("${knife4j.basePackage}")
    String basePackage;
    @Value("${knife4j.groupName}")
    String groupName;

    Contact contact() {
        return new Contact(this.name, this.url, this.email);
    }

    public ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .contact(contact())
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(version).build();
    }
}
