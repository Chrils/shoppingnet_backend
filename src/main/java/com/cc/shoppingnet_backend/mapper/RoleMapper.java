package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectRoleByUserId(Integer userId);
}
