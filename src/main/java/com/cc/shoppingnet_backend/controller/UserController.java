package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.shoppingnet_backend.pojo.Address;
import com.cc.shoppingnet_backend.pojo.Cart;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
import com.cc.shoppingnet_backend.service.AddressService;
import com.cc.shoppingnet_backend.service.CartService;
import com.cc.shoppingnet_backend.service.UserService;
import com.cc.shoppingnet_backend.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/client/user")
public class UserController {

    @Autowired
    UserService service;

    @Autowired
    CartService cartService;

    @Autowired
    AddressService addressService;

    @GetMapping("/getUser")
    public String getUser() {
        return "user";
    }

    @PostMapping("/login")
    // 注意axios传回的是json字符串，需要转换
    public StandardResp login(@RequestBody User param) {
        User user = service.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        StandardResp resp;
        if (user != null){
            resp = StandardResp.getOKResp("登录成功");
            // 添加token
            Map<String,String> map = new HashMap<>();
            map.put("username",user.getUsername());
            map.put("id",user.getId().toString());
            String token = JWTUtils.createToken(map);
            resp.addData("token",token);
            resp.addData("role",user.getUserType());
            resp.addData("cart",cartService.findCartByUid(user.getId()));
            resp.addData("user",user);
        }else{
            resp = StandardResp.getErrorResp("用户名或密码错误");
        }
        return resp;
    }

    @GetMapping("/{id}/address")
    public StandardResp getAddress(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取地址成功");
            resp.addData("list",addressService.list(new QueryWrapper<Address>().eq("addr_user",id)));
        }catch (Exception e){
            e.printStackTrace();
            resp = StandardResp.getErrorResp("获取地址失败");
        }
        return resp;
    }

}
