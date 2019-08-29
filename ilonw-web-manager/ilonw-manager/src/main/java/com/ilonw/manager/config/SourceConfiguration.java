package com.ilonw.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SourceConfiguration extends WebMvcConfigurerAdapter {

    @Value("${loop.upload}")
    private String loopUpload;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/oss/**").addResourceLocations("file:"+loopUpload);
    }
}