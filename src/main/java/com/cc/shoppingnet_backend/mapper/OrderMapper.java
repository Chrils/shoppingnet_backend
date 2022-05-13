package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.TOrder;
import com.cc.shoppingnet_backend.pojo.info.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<TOrder> {
    OrderInfo getDetail(String orderNo);
}
