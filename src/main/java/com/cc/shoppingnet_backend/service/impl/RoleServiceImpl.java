package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.RoleMapper;
import com.cc.shoppingnet_backend.pojo.Role;
import com.cc.shoppingnet_backend.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
