package study.team.leetcode.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    /**
     * 引入Knife4j提供的扩展类
     **/
    private final OpenApiExtensionResolver openApiExtensionResolver;
    @Value("#{myApiInfo}")
    MyApiInfo myApiInfo;

    @Autowired
    public Knife4jConfiguration(OpenApiExtensionResolver openApiExtensionResolver) {
        this.openApiExtensionResolver = openApiExtensionResolver;
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(myApiInfo.getApiInfo())
                // 分组名称
                .groupName(myApiInfo.groupName)
                .select()
                // 这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage(myApiInfo.basePackage))
                .paths(PathSelectors.any())
                .build()
                //赋予插件体系
                .extensions(openApiExtensionResolver.buildExtensions(myApiInfo.groupName));
    }
}
