package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.Role;
import com.cc.shoppingnet_backend.pojo.info.RoleRightInfo;

import java.util.List;

public interface RoleService extends IService<Role> {

    RoleRightInfo listRolesWithRight(Integer roleId);

    List<RoleRightInfo> listAllRolesWithRight();

    void deleteRoleRight(Integer roleId, Integer rightId);

    void addRoleRight(Integer roleId, String rightStr);

    void deleteRole(Integer roleId);
}
