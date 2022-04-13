package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.UserMapper;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
import com.cc.shoppingnet_backend.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public boolean addUser(User user) {
        return mapper.insert(user) > 0;
    }

    @Override
    public Page<User> getUserList(Integer pageNo, Integer size, UserQuery query) {
        Page<User> page = new Page<>(pageNo,size);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(!StringUtils.isNullOrEmpty(query.getUsername())){
            wrapper.like("username",query.getUsername());
        }
        if(!StringUtils.isNullOrEmpty(query.getEmail())){
            wrapper.like("email",query.getEmail());
        }
        if(!StringUtils.isNullOrEmpty(query.getPhone())){
            wrapper.like("phone",query.getPhone());
        }
        if (query.getId() != null) {
            wrapper.eq("id", query.getId());
        }
        if(query.getUserType() != null && query.getUserType() != -1){
            wrapper.eq("user_type",query.getUserType());
        }
        return mapper.selectPage(page, wrapper);
    }

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
