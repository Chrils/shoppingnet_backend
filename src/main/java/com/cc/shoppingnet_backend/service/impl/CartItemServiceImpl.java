package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.CartItemMapper;
import com.cc.shoppingnet_backend.pojo.item.CartItem;
import com.cc.shoppingnet_backend.service.CartItemService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItem> implements CartItemService {
}
