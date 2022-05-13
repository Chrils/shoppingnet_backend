package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.AddressMapper;
import com.cc.shoppingnet_backend.pojo.Address;
import com.cc.shoppingnet_backend.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
}
