package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.temp.CateTemp;
import com.cc.shoppingnet_backend.pojo.tree.CateTreeTemp;

import java.util.List;

public interface CateService extends IService<Cate> {
    Page<CateTreeTemp> findByPage(Integer page, Integer size, Integer maxLevel);
    List<CateTemp> findAll();
    void deleteByIdCascaded(Integer id);
    List<CateTreeTemp> findWithOutPage(Integer maxLevel);
}
