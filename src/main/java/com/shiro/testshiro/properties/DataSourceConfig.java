//package com.shiro.testshiro.properties;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//@Slf4j
//public class DataSourceConfig {
//
//    @Autowired
//    DataBase1Properties dataBase1Properties;
//
//    @Autowired
//    DataBase2Properties dataBase2Properties;
//
//    @Bean(name = "dataBase1DataSource")
//    @Primary
//    public DataSource dataBase1DataSource(){
//        log.info("dataBase1Datasource初始化===========11111111111111");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(dataBase1Properties.getUrl());
//        dataSource.setUsername(dataBase1Properties.getUsername());
//        dataSource.setPassword(dataBase1Properties.getPassword());
//        dataSource.setDriverClassName(dataBase1Properties.getDriverClassName());
//        return dataSource;
//    }
//
//    @Bean(name = "dataBase2DataSource")
//    public DataSource dataBase2DataSource(){
//        log.info("dataBase2Datasource初始化===========22222222222222");
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(dataBase2Properties.getUrl());
//        dataSource.setUsername(dataBase2Properties.getUsername());
//        dataSource.setPassword(dataBase2Properties.getPassword());
//        dataSource.setDriverClassName(dataBase2Properties.getDriverClassName());
//        return dataSource;
//    }
//}
