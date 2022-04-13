package com.cc.shoppingnet_backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
import com.cc.shoppingnet_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShoppingnetBackendApplicationTests {

    @Autowired
    UserService service;

    @Test
    void contextLoads() {
        UserQuery query = new UserQuery();
        query.setUsername("ad");
        Page<User> list = service.getUserList(2, 2, query);
        System.out.println(list.getRecords());
    }



}
