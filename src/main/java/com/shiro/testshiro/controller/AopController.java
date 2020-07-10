package com.shiro.testshiro.controller;

import com.shiro.testshiro.annotation.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AopController {
    @RequestMapping("/second")
    @UserAccess("admin")//通过自定义注解锁定该方法。自定义注解的参数随意，表示通过AOP为该方法实现功能的拓展
    public String testAop(@RequestParam Map map){
        System.out.println("正在controller里调用"+map.get("username"));
        return "调用完毕";
    }
}
