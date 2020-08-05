package com.shiro.testshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.shiro.testshiro.mapper"})

//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

@SpringBootApplication
public class TestShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestShiroApplication.class, args);
    }

}
