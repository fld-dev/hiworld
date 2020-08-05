package com.shiro.testshiro.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    @Override
    public void sendMessage(String msg) {
        System.out.println(msg);
    }
}
