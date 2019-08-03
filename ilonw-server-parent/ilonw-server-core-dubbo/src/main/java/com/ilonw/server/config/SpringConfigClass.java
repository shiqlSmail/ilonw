package com.ilonw.server.config;

import com.ilonw.server.dal.DalConfig;
import com.ilonw.server.dal.DruidConfigration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({DalConfig.class, DruidConfigration.class})
@ImportResource(locations = {"classpath:spring/dubbo.xml"})
public class SpringConfigClass {
}
