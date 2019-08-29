package com.ilonw.file.config;

import com.ilonw.file.Service.FileService;
import com.ilonw.server.bo.file.TableFileBO;
import com.server.tools.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Date;
import java.util.List;

@Configuration
public class SourceConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private FileService fileService;

    @Value("${ilonw.local.reading.img}")
    private String localImgProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        List<TableFileBO> listStr = fileService.selectFilePath();
        for(TableFileBO str : listStr){
            registry.addResourceHandler("/oss/**").addResourceLocations("file:"+localImgProperties+str.getAuther()+"//"+str.getFile_path());
        }
    }
}