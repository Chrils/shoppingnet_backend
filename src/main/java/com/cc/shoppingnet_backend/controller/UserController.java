package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
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
        }else{
            resp = StandardResp.getErrorResp("用户名或密码错误");
        }
        return resp;
    }

}
