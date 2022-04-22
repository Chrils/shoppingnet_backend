package com.cc.shoppingnet_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.shoppingnet_backend.pojo.Attribute;

import java.util.List;

public interface AttributeService extends IService<Attribute> {
    List<Attribute> findCateParams(Integer id, String type);
}
