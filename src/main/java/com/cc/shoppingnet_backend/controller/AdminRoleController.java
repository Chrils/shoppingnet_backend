package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.shoppingnet_backend.pojo.Role;
import com.cc.shoppingnet_backend.pojo.RoleRightInfo;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {

    @Autowired
    private RoleService service;

    @GetMapping("/roles")
    public StandardResp listAllRolesWithRight(){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取角色列表成功");
            resp.addData("list",service.listAllRolesWithRight());
        }catch (Exception e){
            resp = StandardResp.getErrorResp("获取角色列表失败");
        }
        return resp;
    }

    /**
     * 添加角色
     * @param role 角色信息
     * @return
     */
    @PostMapping("/roles")
    public StandardResp addRole(@RequestBody Role role){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加角色成功");
            //调用service添加
            service.save(role);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("添加角色失败");
        }
        return resp;
    }


    @DeleteMapping("/roles/{roleId}")
    public StandardResp deleteRole(@PathVariable Integer roleId){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除角色成功");
            //调用service删除
            service.deleteRole(roleId);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("删除角色失败");
        }
        return resp;
    }

    @PutMapping("/roles")
    public StandardResp updateRole(@RequestBody Role role){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新角色成功");
            //调用service更新
            service.updateById(role);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("更新角色失败");
        }
        return resp;
    }

    /**
     * 删除对应角色的对应权限，如果删除的是高级权限，则删除该角色高级权限及以下的所有子权限
     * @param roleId 角色id
     * @param rightId 权限id
     * @return 删除结果
     */
    @DeleteMapping("/roles/{roleId}/rights/{rightId}")
    public StandardResp deleteRoleRight(@PathVariable Integer rightId, @PathVariable Integer roleId){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除角色权限成功");
            //调用service删除
            service.deleteRoleRight(roleId,rightId);
            //删除成功后，返回最新的角色权限列表
            RoleRightInfo roleRightInfo = service.listRolesWithRight(roleId);
            //添加到返回结果中并回传客户端
            resp.addData("list",roleRightInfo);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("删除角色权限失败");
        }
        return resp;
    }

    /**
     * 添加角色权限
     * @param roleId 角色id
     * @return 添加结果
     * @Question rightStr为post请求体时，会报错，暂时不知道原因
     */
    @PostMapping("/roles/{roleId}/rights/{rightStr}")
    public StandardResp addRoleRight(@PathVariable Integer roleId,@PathVariable String rightStr){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加角色权限成功");
            //调用service添加
            service.addRoleRight(roleId,rightStr);
        }catch (Exception e){
            resp = StandardResp.getErrorResp("添加角色权限失败");
        }
        return resp;
    }


}
