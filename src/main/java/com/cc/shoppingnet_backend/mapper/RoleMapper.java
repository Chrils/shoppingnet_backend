package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Role;
import com.cc.shoppingnet_backend.pojo.info.RoleRightInfo;
import com.cc.shoppingnet_backend.pojo.tree.TRightTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectRoleByUserId(Integer userId);
    RoleRightInfo selectSubRight(Integer roleId);
    TRightTree getRight(Integer roleId);
    List<TRightTree> getChildRight(@Param("role_id") Integer roleId, @Param("right_id")Integer rightId);
    void deleteRoleRight(@Param("roleId") Integer roleId, @Param("rightId") Integer rightId);
    void addRoleRight(@Param("roleId") Integer roleId, @Param("rightIds") List<Integer> rightIds);
    void deleteRoleRightByRoleId(@Param("roleId")Integer roleId);
}
