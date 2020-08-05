package com.shiro.testshiro.controller;

import com.shiro.testshiro.mapper.database1.UserInfoMapper;
import com.shiro.testshiro.mapper.database2.PPCUserInfoMapper;
import com.shiro.testshiro.pojo.database1.UserInfo;
import com.shiro.testshiro.pojo.database2.PPCUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private PPCUserInfoMapper ppcUserInfoMapper;

    @GetMapping(value = "/getuser")
    public List<UserInfo> getuser(){
        List<UserInfo> all = userInfoMapper.findAll();
        return all;
    }
    @GetMapping(value = "/getPPCInfo")
    public List<PPCUserInfo> getPPCInfo(){
        List<PPCUserInfo> all = ppcUserInfoMapper.findAll();
        return all;
    }
}