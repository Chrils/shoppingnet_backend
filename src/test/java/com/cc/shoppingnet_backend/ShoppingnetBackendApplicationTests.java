package com.cc.shoppingnet_backend;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.shoppingnet_backend.mapper.RoleMapper;
import com.cc.shoppingnet_backend.pojo.RoleRightInfo;
import com.cc.shoppingnet_backend.pojo.TRight;
import com.cc.shoppingnet_backend.pojo.TRightTree;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
import com.cc.shoppingnet_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShoppingnetBackendApplicationTests {

    @Autowired
    UserService service;

    @Autowired
    RoleMapper mapper;

    @Test
    void contextLoads() {
        UserQuery query = new UserQuery();
        query.setUsername("ad");
        Page<User> list = service.getUserList(2, 2, query);
        System.out.println(list.getRecords());
    }

    @Test
    void testMapper() {
//        RoleRightInfo info = mapper.selectSubRight(1);
//        List<TRightTree> list = info.getRightTreeList();
//        for (TRightTree rightTree : list) {
//            System.out.println("=====一级====");
//            System.out.println(rightTree.getRightName());
//            List<TRight> children = rightTree.getChildren();
//            for (TRight child : children) {
//                System.out.println(child.getRightName());
//            }
//        }

//        TRightTree childRight = mapper.getChildRight(3, 18);
//        childRight.getChildren().forEach(System.out::println);
        List<TRightTree> childRight = mapper.getChildRight(3, 2);
        System.out.println(childRight);
        for (TRightTree rightTree : childRight) {
            System.out.println("=====一级====");
            System.out.println(rightTree.getRightName());
            for (TRight child : rightTree.getChildren()) {
                System.out.println(child.getRightName());
            }
        } }




}
