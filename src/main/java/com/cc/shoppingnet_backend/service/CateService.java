package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.info.CateInfo;
import com.cc.shoppingnet_backend.pojo.query.CateQuery;
import com.cc.shoppingnet_backend.pojo.tree.CateTree;

import java.util.List;

public interface CateService extends IService<Cate> {
    Page<CateTree> findByPage(Integer page, Integer size, Integer maxLevel);
    List<CateInfo> findAll();
    void deleteByIdCascaded(Integer id);
}
