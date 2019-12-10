package com.example.demo.config;

import com.example.demo.myenum.DataSource_Enum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    private ThreadLocal<DataSource_Enum> threadLocal=new ThreadLocal<>();

    public void switchDataSource(DataSource_Enum dataSource_enum){
        threadLocal.set(dataSource_enum);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return threadLocal.get();
    }
}