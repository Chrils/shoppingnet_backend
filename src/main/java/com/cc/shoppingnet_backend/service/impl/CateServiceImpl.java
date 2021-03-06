package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.AttributeMapper;
import com.cc.shoppingnet_backend.mapper.CateMapper;
import com.cc.shoppingnet_backend.mapper.GoodsMapper;
import com.cc.shoppingnet_backend.pojo.Attribute;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.temp.CateTemp;
import com.cc.shoppingnet_backend.pojo.tree.CateTreeTemp;
import com.cc.shoppingnet_backend.service.AttributeService;
import com.cc.shoppingnet_backend.service.CateService;
import com.cc.shoppingnet_backend.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl extends ServiceImpl<CateMapper, Cate> implements CateService {
    @Autowired
    CateMapper mapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    AttributeMapper attributeMapper;

    /**
     * 不分页获取所有分类，并带有子分类及筛选条件
     * @param maxLevel
     * @return
     */
    @Override
    public List<CateTreeTemp> findWithOutPage(Integer maxLevel) {
        return mapper.findCateByLevelWithoutPage(maxLevel);
    }

    /**
     * 树形分页查询所有分类 并带有子分类及筛选条件
     * @param page
     * @param size
     * @param maxLevel
     * @return
     */
    @Override
    public Page<CateTreeTemp> findByPage(Integer page, Integer size, Integer maxLevel) {
        Page<CateTreeTemp> pageInfo = new Page<>(page, size);
        Integer level = 3;
        if (maxLevel != null) {
            level = maxLevel;
        }
        Integer total = mapper.countByCateLevel(level);
        pageInfo.setTotal(total);
        pageInfo.setPages(total % size == 0 ? total / size : total / size + 1);
        pageInfo.setRecords(mapper.findCateByLevel(level,(page-1)*size,size));
        return pageInfo;
    }



    /**
     * 根据父级id级联删除当前分类及子分类
     * TODO 优化sql语句实现高更新效率
     * @Question 当子分类存在商品时不能删除 当子分类存在参数时，同时删除参数
     * @param id
     */
    @Override
    public void deleteByIdCascaded(Integer id) {
        List<CateTreeTemp> children = mapper.findChildren(id);
        if (children != null && children.size() > 0) {
            //删除子分类
            for (CateTreeTemp cateTree : children) {
                if (cateTree.getChildren() != null && cateTree.getChildren().size() > 0) {
                    //删除子分类的子分类
                    for (Cate cateTree1 : cateTree.getChildren()) {
                        delCalibrate(cateTree1.getCateId());
                    }
                }
                delCalibrate(cateTree.getCateId());
            }
        }
        //删除当前分类
        delCalibrate(id);
    }

    private void delCalibrate(Integer id) {
        if (goodsMapper.selectCount(new QueryWrapper<Goods>().eq("goods_cate", id)) > 0) {
            throw new RuntimeException("当前分类存在商品，不能删除");
        }
        attributeMapper.delete(new QueryWrapper<Attribute>().eq("cate_id", id));
        mapper.deleteById(id);
    }

    /**
     * 查询一二级分类
     * @return
     */
    @Override
    public List<CateTemp> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<Integer> findBottomChildrenByCateId(Integer cate_id, Integer cate_level) {
        return mapper.findBottomChildrenByCateId(cate_id, cate_level);
    }
}
