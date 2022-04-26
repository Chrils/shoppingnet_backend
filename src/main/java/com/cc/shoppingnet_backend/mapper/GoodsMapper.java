package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.info.GoodsAddInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    void addGoodsAttributes(Integer goodsId, Integer attributeId,String attributeValue);
    void removeGoodsAttributes(Integer id);

    void updateGoodsAttributes(Integer goodsId, Integer attributeId, String attributeValue);
    List<GoodsAddInfo.AttrItem> selectGoodsAttributes(Integer id);
}
