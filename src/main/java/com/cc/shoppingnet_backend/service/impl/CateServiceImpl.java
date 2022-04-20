package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.mapper.CateMapper;
import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.info.CateInfo;
import com.cc.shoppingnet_backend.pojo.query.CateQuery;
import com.cc.shoppingnet_backend.pojo.tree.CateTree;
import com.cc.shoppingnet_backend.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl extends ServiceImpl<CateMapper, Cate> implements CateService {
    @Autowired
    CateMapper mapper;

    /**
     * 树形分页查询所有分类 并带有子分类及筛选条件
     * @param page
     * @param size
     * @param maxLevel
     * @return
     */
    @Override
    public Page<CateTree> findByPage(Integer page, Integer size, Integer maxLevel) {
        Page<CateTree> pageInfo = new Page<>(page, size);
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
     * @param id
     */
    @Override
    public void deleteByIdCascaded(Integer id) {
        List<CateTree> children = mapper.findChildren(id);
        if (children != null && children.size() > 0) {
            //删除子分类
            for (CateTree cateTree : children) {
                if (cateTree.getChildren() != null && cateTree.getChildren().size() > 0) {
                    //删除子分类的子分类
                    for (CateTree cateTree1 : cateTree.getChildren()) {
                        mapper.deleteById(cateTree1.getCateId());
                    }
                }
                mapper.deleteById(cateTree.getCateId());
            }
        }
        //删除当前分类
        mapper.deleteById(id);
    }

    /**
     * 查询一二级分类
     * @return
     */
    @Override
    public List<CateInfo> findAll() {
        return mapper.findAll();
    }
}
