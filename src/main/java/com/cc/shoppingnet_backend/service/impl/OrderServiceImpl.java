package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.LogisticsMapper;
import com.cc.shoppingnet_backend.mapper.OrderMapper;
import com.cc.shoppingnet_backend.pojo.Logistics;
import com.cc.shoppingnet_backend.pojo.TOrder;
import com.cc.shoppingnet_backend.pojo.info.OrderInfo;
import com.cc.shoppingnet_backend.pojo.item.OrderItem;
import com.cc.shoppingnet_backend.service.OrderItemService;
import com.cc.shoppingnet_backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, TOrder> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemService orderItemService;

    @Override
    public void saveOrder(OrderInfo order) {
        if (order!=null && order.getOrderItemList()!=null && order.getOrderItemList().size()>0){
            order.setOrderCreateTime(new Date());
            orderMapper.insert((TOrder) order);
            for (OrderItem orderItem : order.getOrderItemList()){
                orderItem.setItemOrder(order.getOrderId());
            }
            orderItemService.saveBatch(order.getOrderItemList());
        }
    }

    @Autowired
    private LogisticsMapper logisticsMapper;

    @Override
    public OrderInfo getDetail(String orderNo) {
        return orderMapper.getDetail(orderNo);
    }

    @Override
    public void removeByIdCascader(Integer id) {
        logisticsMapper.delete(new QueryWrapper<Logistics>().eq("item_order",id));
        orderMapper.deleteById(id);
    }
}
