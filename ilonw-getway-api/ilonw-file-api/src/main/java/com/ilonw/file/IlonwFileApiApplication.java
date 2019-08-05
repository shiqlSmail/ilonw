package com.ilonw.file;

import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class IlonwFileApiApplication {

    public static void main(String[] args) throws Exception  {
        ParserConfig.getGlobalInstance().setAsmEnable(true);
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(IlonwFileApiApplication.class, args);
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
