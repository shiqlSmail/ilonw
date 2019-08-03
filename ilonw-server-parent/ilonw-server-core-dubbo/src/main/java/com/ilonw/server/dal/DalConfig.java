/**
 * pajk.com Inc.
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.ilonw.server.dal;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;


@Configuration
@AutoConfigureAfter({DruidConfigration.class})
@MapperScan(value = "com.ilonw.server.repository", sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class DalConfig {
    @Autowired
    @Qualifier("DataSource")
    public DruidDataSource druidDataSource;
    @Value(value = "classpath*:mybatis/*.xml")
    private Resource[] mapperLocations;
    @Bean(autowire = Autowire.BY_NAME)
    public TransactionTemplate transactionTemplate() {
        TransactionTemplate template = new TransactionTemplate();
        return template;
    }
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(autowire = Autowire.BY_NAME)
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(druidDataSource);
        bean.setMapperLocations(mapperLocations);
        bean.setTypeAliasesPackage("com.ilonw.server.bo");
        // 开启开启驼峰命名转换
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return bean.getObject();
    }
}
