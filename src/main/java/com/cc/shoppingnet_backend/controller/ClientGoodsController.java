package com.cc.shoppingnet_backend.controller;

import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.query.GoodsQuery;
import com.cc.shoppingnet_backend.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/client/goods")
public class ClientGoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/list")
    public StandardResp findByCondition( GoodsQuery query){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取商品信息成功！");
            resp.addData("page",goodsService.findGoodsByCondition(query));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取商品信息失败！");
            log.error("获取商品信息失败！",e);
        }
        return resp;
    }

    @GetMapping("/detail/{id}")
    public StandardResp findById(@PathVariable("id") Integer id){
        StandardResp resp;
        try {
            if (id == null){
                throw new RuntimeException("商品id不能为空！");
            }
            resp = StandardResp.getOKResp("获取商品详情成功！");
            resp.addData("item",goodsService.getById(id));
            resp.addData("params",goodsService.getGoodsAttributes(id));
            resp.addData("urlPrefix","http://localhost:9999/images/");
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取商品详情失败！");
            log.error("获取商品详情失败！",e);
        }
        return resp;
    }
}
