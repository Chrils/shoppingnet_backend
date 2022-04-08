package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.UserMapper;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return mapper.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }
}
