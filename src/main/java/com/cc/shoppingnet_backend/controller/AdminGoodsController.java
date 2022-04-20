package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.tree.CateTree;
import com.cc.shoppingnet_backend.service.CateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    CateService service;

    /**
     * 获取商品分类树
     * @param maxLevel 最大层级 默认为1 即获取一级分类以及其子分类  如果为2 则获取二级分类以及其子分类
     * @param pageNo 页码
     * @param pageSize 每页数量
     * @return
     */
    @GetMapping("/cate")
    public StandardResp cates(
            @RequestParam(required = false,defaultValue = "1") Integer maxLevel,
            @RequestParam(required = false,defaultValue = "1") Integer pageNo,
            @RequestParam(required = false,defaultValue = "5") Integer pageSize){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询分类列表成功");
            Page<CateTree> page = service.findByPage(pageNo, pageSize, maxLevel);
            resp.addData("page", page);
        }catch (Exception e){
            log.error("查询分类列表失败", e);
            resp = StandardResp.getErrorResp("查询分类列表失败");
        }
        return resp;
    }

    /**
     * 获取商品一二级分类
     * TODO 与cates合并改成通用接口并能够根据传入的数值动态获取前n级分类
     * @return
     */
    @GetMapping("/cate/list")
    public StandardResp cateList(){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询分类列表成功");
            resp.addData("list", service.findAll());
        }catch (Exception e){
            log.error("查询分类列表失败", e);
            resp = StandardResp.getErrorResp("查询分类列表失败");
        }
        return resp;
    }

    /**
     * 添加商品分类
     * @param cate
     * @return
     */
    @PostMapping("/cate")
    public StandardResp addCate(@RequestBody Cate cate){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加分类成功");
            service.save(cate);
        }catch (Exception e){
            log.error("添加分类失败", e);
            resp = StandardResp.getErrorResp("添加分类失败");
        }
        return resp;
    }

    /**
     * 更新商品分类
     * @param cate
     * @return
     */
    @PutMapping("/cate")
    public StandardResp updateCate(@RequestBody Cate cate){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新分类成功");
            service.updateById(cate);
        }catch (Exception e){
            log.error("更新分类失败", e);
            resp = StandardResp.getErrorResp("更新分类失败");
        }
        return resp;
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    @DeleteMapping("/cate/{id}")
    public StandardResp deleteCate(@PathVariable("id") Integer id){
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除分类成功");
            service.deleteByIdCascaded(id);
        }catch (Exception e){
            log.error("删除分类失败", e);
            resp = StandardResp.getErrorResp("删除分类失败");
        }
        return resp;
    }

}
