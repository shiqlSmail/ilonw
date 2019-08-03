package com.ilonw.api;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class IlonwSmsApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception  {
        ParserConfig.getGlobalInstance().setAsmEnable(true);
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(IlonwSmsApiApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
