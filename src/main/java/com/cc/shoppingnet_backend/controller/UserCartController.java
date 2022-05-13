package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.item.CartItem;
import com.cc.shoppingnet_backend.service.CartItemService;
import com.cc.shoppingnet_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/cart")
public class UserCartController {

    @Autowired
    CartService cartService;

    @Autowired
    CartItemService cartItemService;

    @GetMapping("/{id}")
    public StandardResp getCart(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取购物车信息成功");
            resp.addData("cart", cartService.findCartByUid(id));
        }catch (Exception e) {
            resp = StandardResp.getErrorResp("获取购物车信息失败");
        }
        return resp;
    }

    @DeleteMapping("/{id}")
    public StandardResp deleteCart(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("移除购物车成功");
            cartService.removeById(id);
        }catch (Exception e) {
            resp = StandardResp.getErrorResp("移除购物车失败");
        }
        return resp;
    }

    @PostMapping("/item")
    public StandardResp addItem(@RequestBody CartItem item) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加购物车商品成功");
            cartItemService.save(item);
        }catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("添加购物车商品失败");
        }
        return resp;
    }

    @DeleteMapping("/item/{id}")
    public StandardResp deleteItem(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("移除购物车商品成功");
            cartItemService.removeById(id);
        }catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("移除购物车商品失败");
        }
        return resp;
    }

    @PutMapping("/item")
    public StandardResp updateItem(@RequestBody CartItem item) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新购物车商品信息成功");
            cartItemService.updateById(item);
        }catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("更新购物车商品信息失败");
        }
        return resp;
    }

}
