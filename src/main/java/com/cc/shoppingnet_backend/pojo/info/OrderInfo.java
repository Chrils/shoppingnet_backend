package com.cc.shoppingnet_backend.pojo.info;

import com.cc.shoppingnet_backend.pojo.Address;
import com.cc.shoppingnet_backend.pojo.TOrder;
import com.cc.shoppingnet_backend.pojo.item.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderInfo extends TOrder {
    private List<OrderItem> orderItemList;
    private Address address;
}
