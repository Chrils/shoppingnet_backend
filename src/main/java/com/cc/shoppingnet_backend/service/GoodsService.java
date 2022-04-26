package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.info.GoodsAddInfo;
import com.cc.shoppingnet_backend.pojo.query.GoodsQuery;

import java.util.Date;
import java.util.List;

public interface GoodsService extends IService<Goods> {
    Page<Goods> findGoodsByCondition(GoodsQuery query);
    void saveGoodsInfo(GoodsAddInfo info);
    //级联删除商品信息
    void removeCascader(Integer id);

    void updateGoodsInfo(GoodsAddInfo info);
    List<GoodsAddInfo.AttrItem> getGoodsAttributes(Integer id);
}
