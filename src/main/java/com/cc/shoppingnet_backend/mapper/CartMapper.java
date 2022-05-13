package com.cc.shoppingnet_backend.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    Cart findCartByUid(Integer uid);
}
