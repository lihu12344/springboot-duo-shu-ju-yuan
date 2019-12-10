package com.example.demo.aop;

import com.example.demo.config.DynamicDataSource;
import com.example.demo.myenum.DataSource_Enum;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Aspect
@Component
public class CustomAspect {

    @Resource
    private DynamicDataSource dataSource;

    @Pointcut("execution(* *..UserMapper.*(..))")
    public void funOne(){
    }

    @Pointcut("execution(* *..PersonMapper.*(..))")
    public void funTwo(){
    }

    @Before("funOne()")
    public void beforeOne(){
        dataSource.switchDataSource(DataSource_Enum.one);
    }

    @Before("funTwo()")
    public void beforeTwo(){
        dataSource.switchDataSource(DataSource_Enum.two);
    }
}