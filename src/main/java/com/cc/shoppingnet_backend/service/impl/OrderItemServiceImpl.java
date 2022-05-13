package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.OrderItemMapper;
import com.cc.shoppingnet_backend.pojo.item.OrderItem;
import com.cc.shoppingnet_backend.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements OrderItemService {
}
