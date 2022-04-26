package com.cc.shoppingnet_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.shoppingnet_backend.pojo.Attribute;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.StandardResp;
import com.cc.shoppingnet_backend.pojo.info.GoodsAddInfo;
import com.cc.shoppingnet_backend.pojo.tree.CateTreeTemp;
import com.cc.shoppingnet_backend.service.AttributeService;
import com.cc.shoppingnet_backend.service.CateService;
import com.cc.shoppingnet_backend.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/admin/goods")
public class AdminGoodsController {

    @Autowired
    CateService service;

    @Autowired
    AttributeService attributeService;

    @Autowired
    GoodsService goodsService;

    /**
     * 获取商品分类树
     *
     * @param maxLevel 最大层级 默认为1 即获取一级分类以及其子分类  如果为2 则获取二级分类以及其子分类
     * @param pageNo   页码  当不传入时则不进行分页
     * @param pageSize 每页数量 当不传入时则不进行分页
     * @return
     */
    @GetMapping("/cate")
    public StandardResp cates(
            @RequestParam(required = false, defaultValue = "1") Integer maxLevel,
            @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer pageSize) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询分类列表成功");
            if (pageNo == null || pageSize == null) {
                resp.addData("list", service.findWithOutPage(maxLevel));
            } else {
                Page<CateTreeTemp> page = service.findByPage(pageNo, pageSize, maxLevel);
                resp.addData("page", page);
            }
        } catch (Exception e) {
            log.error("查询分类列表失败", e);
            resp = StandardResp.getErrorResp("查询分类列表失败");
        }
        return resp;
    }

    /**
     * 获取商品一二级分类
     * TODO 与cates合并改成通用接口并能够根据传入的数值动态获取前n级分类
     *
     * @return
     */
    @GetMapping("/cate/list")
    public StandardResp cateList() {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询分类列表成功");
            resp.addData("list", service.findAll());
        } catch (Exception e) {
            log.error("查询分类列表失败", e);
            resp = StandardResp.getErrorResp("查询分类列表失败");
        }
        return resp;
    }

    /**
     * 添加商品分类
     *
     * @param cate
     * @return
     */
    @PostMapping("/cate")
    public StandardResp addCate(@RequestBody Cate cate) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加分类成功");
            service.save(cate);
        } catch (Exception e) {
            log.error("添加分类失败", e);
            resp = StandardResp.getErrorResp("添加分类失败");
        }
        return resp;
    }

    /**
     * 更新商品分类
     *
     * @param cate
     * @return
     */
    @PutMapping("/cate")
    public StandardResp updateCate(@RequestBody Cate cate) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新分类成功");
            service.updateById(cate);
        } catch (Exception e) {
            log.error("更新分类失败", e);
            resp = StandardResp.getErrorResp("更新分类失败");
        }
        return resp;
    }

    /**
     * 删除商品分类
     *
     * @param id
     * @return
     */
    @DeleteMapping("/cate/{id}")
    public StandardResp deleteCate(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除分类成功");
            service.deleteByIdCascaded(id);
        } catch (Exception e) {
            log.error("删除分类失败", e);
            resp = StandardResp.getErrorResp("删除分类失败");
        }
        return resp;
    }

    /**
     * 获取对应类别id下的指定类型的参数
     *
     * @param id
     * @param type
     * @return
     */
    @GetMapping("/cate/{id}/params/{type}")
    public StandardResp getCateParams(@PathVariable("id") Integer id, @PathVariable("type") String type) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("获取参数成功");
            resp.addData("list", attributeService.findCateParams(id, type));
        } catch (Exception e) {
            log.error("获取参数失败", e);
            resp = StandardResp.getErrorResp("获取参数失败");
        }
        return resp;
    }

    /**
     * 根据参数id获取参数信息
     *
     * @param id 参数id
     * @return
     */
    @GetMapping("/cate/params/{id}")
    public StandardResp getCateParamsByAttrId(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询参数成功！");
            resp.addData("item", attributeService.getById(id));
        } catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("获取参数失败！");
        }
        return resp;
    }

    /**
     * 删除商品分类参数
     *
     * @param id 参数id
     * @return
     */
    @DeleteMapping("/cate/params/{id}")
    public StandardResp deleteCateParams(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除参数成功！");
            attributeService.removeById(id);
        } catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("删除参数失败！");
        }
        return resp;
    }

    /**
     * 修改商品分类参数
     *
     * @param attribute 参数封装对象
     * @return
     */
    @PutMapping("/cate/params")
    public StandardResp updateCateParams(@RequestBody Attribute attribute) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新参数成功！");
            attributeService.updateById(attribute);
        } catch (Exception e) {
            e.printStackTrace();
            resp = StandardResp.getErrorResp("更新参数失败！");
        }
        return resp;
    }

    /**
     * 为指定类别添加指定类型的参数
     *
     * @param attribute 参数封装对象
     * @return
     */
    @PostMapping("/cate/params")
    public StandardResp addCateParams(@RequestBody Attribute attribute) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加参数成功！");
            attributeService.save(attribute);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("添加参数失败！");
        }
        return resp;
    }

    /**
     * 商品图片文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public StandardResp upload(@RequestPart("file") MultipartFile file) throws IOException {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("上传成功！");
            String fileName = file.getOriginalFilename();
            if (fileName == null || fileName.equals("")) {
                throw new IOException("文件名为空！");
            }
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String newFileName = "tmp_"+UUID.randomUUID().toString() + "." + suffix;
            File folder = new File("E:\\upload\\temp");
            if (!folder.exists()) {
                synchronized (this){
                    boolean b = folder.mkdirs();
                    if (!b){
                        throw new RuntimeException("temp文件夹创建失败");
                    }
                }
            }
            String path = "E:\\upload\\temp\\" + newFileName;
            File dest = new File(path);
            file.transferTo(dest);
            resp.addData("url", "http://localhost:9999/temp/" + newFileName);
            resp.addData("path",newFileName);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("上传失败！");
        }
        return resp;
    }

    /**
     * 修改商品信息
     * @param info 商品详情信息（包含参数）
     * @return
     */
    @PutMapping("/goods")
    public StandardResp update(@RequestBody GoodsAddInfo info) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("更新商品信息成功！");
            goodsService.updateGoodsInfo(info);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("更新商品信息失败！");
            log.error("更新商品信息失败！", e);
        }
        return resp;
    }

    /**
     * 根据id删除单个商品
     * @param id
     * @return
     */
    @DeleteMapping("/goods/{id}")
    public StandardResp delete(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除商品信息成功！");
            goodsService.removeCascader(id);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("删除商品信息失败！");
            log.error("删除商品信息失败！", e);
        }
        return resp;
    }

    /**
     * 根据id连接字符串删除多个商品
     * @param ids
     * @return
     */
    @DeleteMapping("/goods")
    public StandardResp deleteMany(@RequestParam("ids") String ids) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("删除商品信息成功！");
            String[] idArray = ids.split(",");
            for (String id : idArray) {
                goodsService.removeById(Integer.parseInt(id));
            }
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("删除商品信息失败！");
            log.error("删除商品信息失败！", e);
        }
        return resp;
    }

    /**
     * 添加商品
     * @param info
     * @return
     */
    @PostMapping("/goods")
    public StandardResp add(@RequestBody GoodsAddInfo info) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("添加商品信息成功！");
            goodsService.saveGoodsInfo(info);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("添加商品信息失败！");
            log.error("添加商品信息失败！", e);
        }
        return resp;
    }

    /**
     * 根据商品id查询商品信息
     * @param id
     * @return
     */
    @GetMapping("/goods/{id}")
    public StandardResp findById(@PathVariable("id") Integer id) {
        StandardResp resp;
        try {
            resp = StandardResp.getOKResp("查询商品信息成功！");
            Goods goods = goodsService.getById(id);
            resp.addData("goods", goods);
        } catch (Exception e) {
            resp = StandardResp.getErrorResp("查询商品信息失败！");
            log.error("查询商品信息失败！", e);
        }
        return resp;
    }



}
