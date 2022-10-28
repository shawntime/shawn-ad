package com.shawntime.ad.configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author mashaohua
 * @date 2022/10/27 20:17
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        converters.add(0, stringHttpMessageConverter());
        converters.add(1, enhancedFastJsonHttpMessageConverter());
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter();
        List<MediaType> mediaTypes = Stream.of(MediaType.TEXT_PLAIN).collect(Collectors.toList());
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

    @Bean
    public FastJsonHttpMessageConverter enhancedFastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = Stream.of(MediaType.APPLICATION_JSON_UTF8).collect(Collectors.toList());
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.DisableCircularReferenceDetect);
        return converter;
    }
}
