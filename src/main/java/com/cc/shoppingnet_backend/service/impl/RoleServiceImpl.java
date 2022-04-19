package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.RoleMapper;
import com.cc.shoppingnet_backend.pojo.Role;
import com.cc.shoppingnet_backend.pojo.RoleRightInfo;
import com.cc.shoppingnet_backend.pojo.TRight;
import com.cc.shoppingnet_backend.pojo.TRightTree;
import com.cc.shoppingnet_backend.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleRightInfo listRolesWithRight(Integer roleId) {
        return roleMapper.selectSubRight(roleId);
    }

    @Override
    public List<RoleRightInfo> listAllRolesWithRight() {
        List<Role> roles = roleMapper.selectList(new QueryWrapper<>());
        List<RoleRightInfo> roleRightInfos = new ArrayList<>(roles.size());
        for (Role role : roles) {
            roleRightInfos.add(roleMapper.selectSubRight(role.getRoleId()));
        }
        return roleRightInfos;
    }

    /**
     * 添加对应角色的对应权限
     * @param roleId
     * @param rightStr
     * TODO 如果添加的是低级权限，则添加对应的高级权限
     */
    @Override
    public void addRoleRight(Integer roleId, String rightStr) {
        //先删除当前角色的所有权限
        roleMapper.deleteRoleRightByRoleId(roleId);
        //将rightStr转化为List<Integer>
        List<Integer> rightIds = new ArrayList<>();
        String[] split = rightStr.split(",");
        for (String rightId : split) {
            rightIds.add(Integer.valueOf(rightId));
        }
        //添加对应角色的对应权限
        roleMapper.addRoleRight(roleId, rightIds);
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleMapper.deleteRoleRightByRoleId(roleId);
        roleMapper.deleteById(roleId);
    }

    /**
     * 删除对应角色的对应权限，如果删除的是高级权限，则删除该角色高级权限及以下的所有子权限
     * @param roleId 角色id
     * @param rightId 权限id
     * TODO 优化sql语句实现高更新效率
     */
    @Override
    public void deleteRoleRight(Integer roleId, Integer rightId) {
        //拿到当前角色的当前权限下的所有子权限
        List<TRightTree> treeList = roleMapper.getChildRight(roleId, rightId);

        //遍历删除当前角色的当前权限下的所有子权限
        for (TRightTree tRightTree : treeList) {
            //删除三级权限
            if (tRightTree.getChildren() != null) {
                for (TRight tRight : tRightTree.getChildren()) {
                    roleMapper.deleteRoleRight(roleId, tRight.getRightId());
                }
            }
            //删除二级权限
            roleMapper.deleteRoleRight(roleId, tRightTree.getRightId());
        }
        //删除当前角色的当前权限
        roleMapper.deleteRoleRight(roleId, rightId);
    }
}
