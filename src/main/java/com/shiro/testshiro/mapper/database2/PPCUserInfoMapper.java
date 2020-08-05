package com.shiro.testshiro.mapper.database2;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shiro.testshiro.pojo.database2.PPCUserInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PPCUserInfoMapper {
    @Select("select * from gw_game_ppc_user_info")
    List<PPCUserInfo> findAll();
}
