package com.ilonw.api.manager.config;

import com.server.tools.cache.Cache;
import com.server.tools.encryption.DESUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.*;

/**
 * 系统配置类
 * 主要为了获取properties里面的各个接口路径值
 */
public class SystemConfig {
    protected static final Logger log = LoggerFactory.getLogger(SystemConfig.class);

    /**
     * 获取properties的所有key-value
     */
    public static String getProperties(String sysConfigKey) {
        Properties pop = new Properties();
        try{
            InputStream in = SystemConfig.class.getResourceAsStream("/application-dev.properties");
            pop.load(in);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        Enumeration em = pop.propertyNames();
        while(em.hasMoreElements()) {
            String key = (String) em.nextElement();
            String value = pop.getProperty(key);
            Cache.put(key,value);
        }
        String value = (String)Cache.get(sysConfigKey);
        log.info("从缓存中取出value信息："+value);
        return value;
    }

    public static void main(String[] args) throws Exception{
      /* String listMap = SystemConfig.getProperties("checkUserSms");
        System.out.println(listMap);*/

        String source = "http://www.ilonw.com/";
        System.out.println("原文: " + source);
        String encryptData = DESUtil.encryptVal(source);
        System.out.println("加密后: " + encryptData);
        String decryptData = DESUtil.decipherVal(encryptData);
        System.out.println("解密后: " + decryptData);

    }
}
