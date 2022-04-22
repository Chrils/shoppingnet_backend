package com.cc.shoppingnet_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.temp.CateTemp;
import com.cc.shoppingnet_backend.pojo.tree.CateTreeTemp;

import java.util.List;

public interface CateMapper extends BaseMapper<Cate> {
    List<CateTreeTemp> findCateByLevel(Integer level, Integer start, Integer end);
    List<CateTreeTemp> findCateByLevelWithoutPage(Integer level);
    Integer countByCateLevel(Integer level);
    List<CateTemp> findAll();
    List<CateTreeTemp> findChildren(Integer id);
}
