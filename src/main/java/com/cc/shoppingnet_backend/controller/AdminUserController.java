package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.User;
import com.cc.shoppingnet_backend.pojo.query.UserQuery;
import com.cc.shoppingnet_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    UserService service;

    /**
     * 根据id查看用户
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public StandardResp getUser(@PathVariable("id") Integer id){
        StandardResp resp;
        try{
            resp = StandardResp.getOKResp("查询成功");
            resp.addData("user",service.getById(id));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("查询失败");
        }
        return resp;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/users/{id}")
    public StandardResp deleteUser(@PathVariable("id") Integer id){
        StandardResp resp;
        try{
            if(service.removeById(id)){
                resp = StandardResp.getOKResp("删除成功");
            }else{
                resp = StandardResp.getErrorResp("删除失败");
            }
        }catch (Exception e){
            resp = StandardResp.getErrorResp("删除失败");
        }
        return resp;
    }


    @GetMapping("/list")
    public StandardResp getUserList(
            @RequestParam(value = "pageNo",defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer size,
            UserQuery param
    )
    {
        StandardResp resp;
        try{
            resp = StandardResp.getOKResp("查询成功");
            resp.addData("page",service.getUserList(page,size,param));
        }catch (Exception e){
            resp = StandardResp.getErrorResp("查询失败");
        }
        return resp;
    }

    /**
     * 添加用户
     * @param param
     * @return
     */
    @PutMapping("/add")
    public StandardResp addUser(@RequestBody User param){
        StandardResp resp;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",param.getUsername());
        try{
            if (service.getOne(wrapper) != null){
                resp = StandardResp.getErrorResp("用户名已存在");
            }else{
                if(service.addUser(param)){
                    resp = StandardResp.getOKResp("添加成功");
                }else{
                    resp = StandardResp.getErrorResp("添加失败");
                }
            }
        }catch (Exception e){
            resp = StandardResp.getErrorResp("添加失败");
        }
        return resp;
    }

    /**
     * 修改用户
     * @param param
     * @return
     */
    @PutMapping("/update")
    public StandardResp updateUser(@RequestBody User param){
        StandardResp resp;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (param.getId() != null){
            wrapper.eq("id",param.getId());
        }
        try{
            if(service.update(param,wrapper)){
                resp = StandardResp.getOKResp("修改成功");
            }else{
                resp = StandardResp.getErrorResp("修改失败");
            }
        }catch (Exception e){
            resp = StandardResp.getErrorResp("修改失败");
        }
        return resp;
    }

}
