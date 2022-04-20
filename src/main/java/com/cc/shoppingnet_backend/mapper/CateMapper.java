package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.info.CateInfo;
import com.cc.shoppingnet_backend.pojo.tree.CateTree;

import java.util.List;

public interface CateMapper extends BaseMapper<Cate> {
    List<CateTree> findCateByLevel(Integer level,Integer start,Integer end);
    Integer countByCateLevel(Integer level);
    List<CateInfo> findAll();
    List<CateTree> findChildren(Integer id);
}
