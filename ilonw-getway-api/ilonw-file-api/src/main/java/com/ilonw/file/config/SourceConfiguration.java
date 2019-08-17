package com.ilonw.file.config;

import com.server.tools.date.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;

@Configuration
public class SourceConfiguration extends WebMvcConfigurerAdapter {

    @Value("${ilonw.local.reading.img}")
    private String localImgProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/loacl/img/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/oss/**").addResourceLocations("file:"+localImgProperties);
    }
}