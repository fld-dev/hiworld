package com.shiro.testshiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.shiro.testshiro.mapper"})

@SpringBootApplication

public class TestShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestShiroApplication.class, args);
    }

}
