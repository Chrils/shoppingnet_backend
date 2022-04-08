package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.CONST.menu.Menu;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin/base")
public class AdminBaseController {

    @GetMapping("/menus")
    public StandardResp menus() {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取菜单成功");
            resp.addData("menus",Menu.DEFAULT);
        }catch (Exception e) {
            resp = StandardResp.getErrorResp("获取菜单失败");
        }
        return resp;
    }
}