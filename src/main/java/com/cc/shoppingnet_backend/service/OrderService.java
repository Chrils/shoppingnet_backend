package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.TOrder;
import com.cc.shoppingnet_backend.pojo.info.OrderInfo;

public interface OrderService extends IService<TOrder> {
    OrderInfo getDetail(String orderNo);

    void removeByIdCascader(Integer id);

    void saveOrder(OrderInfo order);
}
