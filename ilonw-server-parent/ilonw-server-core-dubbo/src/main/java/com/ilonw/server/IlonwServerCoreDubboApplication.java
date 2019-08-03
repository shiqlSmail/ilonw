package com.ilonw.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ServletComponentScan
@ImportResource(locations = { "classpath:druid-bean.xml"})
@EnableScheduling //开启定时任务
public class IlonwServerCoreDubboApplication {

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(IlonwServerCoreDubboApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
