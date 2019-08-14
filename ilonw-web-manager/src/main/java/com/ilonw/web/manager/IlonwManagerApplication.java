package com.ilonw.web.manager;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication
public class IlonwManagerApplication {

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(IlonwManagerApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
