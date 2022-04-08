package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.User;

public interface UserService extends IService<User> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);
}
