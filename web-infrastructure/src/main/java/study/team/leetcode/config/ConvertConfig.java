package study.team.leetcode.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.List;

/**
 * @author JiaHao
 * @version 1.0
 * @date 2022-11-07 11:13
 * @description 类型转换配置
 */
@Configuration
public class ConvertConfig {
    /**
     * 注册我们自定义的转换器
     *
     * @param converters        转换器列表
     * @param conversionService 转换服务
     * @param <T>               转换源泛型
     * @param <R>               转换目标泛型
     */
    public <T, R> ConvertConfig(List<Converter<T, R>> converters, GenericConversionService conversionService) {
        converters.forEach(conversionService::addConverter);
    }
}
