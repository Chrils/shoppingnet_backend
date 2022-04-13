package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;

import java.util.List;

public interface UserService extends IService<User> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
    Page<User> getUserList(Integer page, Integer size, UserQuery query);
    boolean addUser(User user);
}
