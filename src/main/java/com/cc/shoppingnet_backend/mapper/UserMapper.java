package com.cc.shoppingnet_backend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 判断用户登录
     */
    User findByUsernameAndPassword(String username, String password);
}
