package com.shiro.testshiro.mapper.database1;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface UserInfoMapper {

    @Select("SELECT * FROM sys_users")
    List<com.shiro.testshiro.pojo.database1.UserInfo> findAll();
}
