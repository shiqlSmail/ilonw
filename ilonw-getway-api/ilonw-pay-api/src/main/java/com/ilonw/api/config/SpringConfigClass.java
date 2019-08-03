package com.ilonw.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"classpath:wxpay-bean.xml","classpath:spring/dubbo.xml"})
public class SpringConfigClass {
}
