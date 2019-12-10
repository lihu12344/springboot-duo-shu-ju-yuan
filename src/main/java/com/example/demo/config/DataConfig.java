package com.example.demo.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.example.demo.myenum.DataSource_Enum;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
@MapperScan("com.example.demo.dao")
public class DataConfig {

    @Bean
    public PaginationInterceptor initPaginationInterceptor(){
        return new PaginationInterceptor();
    }

    @Bean
    public OptimisticLockerInterceptor initOptimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    @Bean("one")
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource initOneDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean("two")
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource initSecondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource initDynamicDataSource(@Qualifier("one") DataSource ds1, @Qualifier("two") DataSource ds2){
        DynamicDataSource dynamicDataSource=new DynamicDataSource();

        Map<Object,Object> map=new HashMap<>();
        map.put(DataSource_Enum.one,ds1);
        map.put(DataSource_Enum.two,ds2);
        dynamicDataSource.setTargetDataSources(map);

        dynamicDataSource.setDefaultTargetDataSource(ds1);

        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager initPlatformTransactionManager(DynamicDataSource dynamicDataSource){
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}