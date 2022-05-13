package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.item.OrderItem;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
