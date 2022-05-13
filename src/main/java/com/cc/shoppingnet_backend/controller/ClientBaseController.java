package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client/base")
public class ClientBaseController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/banner")
    public StandardResp banner(){
        StandardResp resp;
        try{
            resp = StandardResp.getOKResp("获取banner信息成功!");
            List<Goods> banner = goodsService.findBanner();
            resp.addData("banner",banner);
            resp.addData("urlPrefix","http://localhost:9999/images/");
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取banner信息失败！");
            e.printStackTrace();
        }
        return resp;
    }

    @GetMapping("/hot")
    public StandardResp hot(){
        StandardResp resp;
        try{
            resp = StandardResp.getOKResp("获取热门商品信息成功!");
            List<Goods> hot = goodsService.findHot();
            resp.addData("list",hot);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取热门商品信息失败！");
            e.printStackTrace();
        }
        return resp;
    }

    @GetMapping("/new")
    public StandardResp newGoods(){
        StandardResp resp;
        try{
            resp = StandardResp.getOKResp("获取最新商品信息成功!");
            List<Goods> newGoods = goodsService.findNew();
            resp.addData("list",newGoods);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取最新商品信息失败！");
            e.printStackTrace();
        }
        return resp;
    }

}
