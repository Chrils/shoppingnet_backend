package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.CartMapper;
import com.cc.shoppingnet_backend.pojo.Cart;
import com.cc.shoppingnet_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public Cart findCartByUid(Integer uid) {
        Cart cart = cartMapper.findCartByUid(uid);
        if (cart == null) {
            // 如果没有购物车，则创建一个
            cart = new Cart();
            cart.setCartUser(uid);
            cartMapper.insert(cart);
        }
        return cart;
    }
}
