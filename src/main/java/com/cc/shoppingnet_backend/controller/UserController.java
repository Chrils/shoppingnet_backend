package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.pojo.User;
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
    public Map<String,String> login(@RequestBody User param) {
        User user = service.findByUsernameAndPassword(param.getUsername(), param.getPassword());
        Map<String,String> paramMap = new HashMap<>();
        if (user != null){
            // 添加token
            Map<String,String> map = new HashMap<>();
            map.put("username",user.getUsername());
            map.put("id",user.getId().toString());
            String token = JWTUtils.createToken(map);
            paramMap.put("token",token);
            paramMap.put("state","success");
        }else{
            paramMap.put("state","fail");
        }
        return paramMap;
    }

}
