package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.AttributeMapper;
import com.cc.shoppingnet_backend.pojo.Attribute;
import com.cc.shoppingnet_backend.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl extends ServiceImpl<AttributeMapper, Attribute> implements AttributeService {

    @Autowired
    AttributeMapper mapper;

    /**
     * 根据类别id以及参数类型查询类别参数
     * @param id
     * @param type
     * @return
     */
    @Override
    public List<Attribute> findCateParams(Integer id, String type) {
        QueryWrapper<Attribute> wrapper = new QueryWrapper<>();
        wrapper.eq("cate_id", id);
        wrapper.eq("attr_sel", type);
        return mapper.selectList(wrapper);
    }
}
