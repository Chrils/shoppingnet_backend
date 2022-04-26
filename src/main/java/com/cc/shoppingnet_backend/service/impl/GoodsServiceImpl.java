package com.cc.shoppingnet_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.shoppingnet_backend.CONST.File.FileConst;
import com.cc.shoppingnet_backend.mapper.GoodsMapper;
import com.cc.shoppingnet_backend.pojo.Goods;
import com.cc.shoppingnet_backend.pojo.info.GoodsAddInfo;
import com.cc.shoppingnet_backend.pojo.query.GoodsQuery;
import com.cc.shoppingnet_backend.service.CateService;
import com.cc.shoppingnet_backend.service.GoodsService;
import com.cc.shoppingnet_backend.utils.EntityUtils;
import com.mysql.cj.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Transactional
@Slf4j
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CateService cateService;

    /**
     * 级联删除商品信息
     * @param id
     */
    @Override
    public void removeCascader(Integer id) {
        //查询商品信息
        Goods goods = goodsMapper.selectById(id);
        //删除商品参数表信息
        goodsMapper.removeGoodsAttributes(id);
        //删除商品图片
        String[] imgs = goods.getGoodsImgs().split(" ");
        for (String img : imgs) {
            File file = new File(FileConst.REAL_FILE_PREFIX + img);
            if (file.exists()) {
                FileSystemUtils.deleteRecursively(file);
            }
        }
        // 删除商品
        goodsMapper.deleteById(id);
    }

    /**
     * 添加商品信息
     * @param info
     */
    @Override
    public void saveGoodsInfo(GoodsAddInfo info) {
        Goods goods = new Goods();
        EntityUtils.copyProperties(info,goods); // 将info中的属性复制到goods中
        goodsMapper.insert(goods); // 将goods插入数据库,调用mapper中的insert后，会自动设置goods的id
        log.info("goods信息插入成功！");
        // 将goods中饿goodsImgs转换成数组
        String[] imgs = info.getGoodsImgs().split(" ");
        // 取出数组中的每个元素对应的图片并保存到服务器中
        for (String img : imgs) {
            // 取出原图片的文件路径
            String oldImgPath = FileConst.TEMP_FILE_PREFIX + img;
            // 设置新的图片路径
            String newImgPath = FileConst.REAL_FILE_PREFIX + img;
            //将图片从临时文件夹移动到正式文件夹
            try {
                log.info("开始移动图片！{}->{}",oldImgPath,newImgPath);
                FileSystemUtils.copyRecursively(new File(oldImgPath),new File(newImgPath));
                log.info("图片移动成功！");
            } catch (IOException e) {
                log.error("保存图片失败！可能的原因：原图片已被删除，更多信息：{}",e.getMessage());
            }
        }
        //清空临时文件夹
        log.info("开始清空临时文件夹！");
        FileSystemUtils.deleteRecursively(new File(FileConst.TEMP_FILE_PREFIX));
        log.info("临时文件夹清空成功！");

        log.info("开始保存商品参数信息！");
        //拿到info的参数items，将商品参数存入数据库表中
        for (GoodsAddInfo.AttrItem attrItem : info.getAttrs()) {
            goodsMapper.addGoodsAttributes(goods.getGoodsId(),attrItem.getAttrId(),attrItem.getAttrVals());
        }
        log.info("商品参数信息保存成功！");
        log.info("已完成");
    }

    /**
     * 更新商品信息
     * @param info 商品信息
     */
    @Override
    public void updateGoodsInfo(GoodsAddInfo info) {
        Goods goods = new Goods();
        EntityUtils.copyProperties(info,goods); // 将info中的属性复制到goods中
        goodsMapper.updateById(info); // 将goods插入数据库
        log.info("goods信息修改成功！");
        File folder = new File("E:\\upload\\temp");
        if (!folder.exists()) {
            synchronized (this){
                boolean b = folder.mkdirs();
                if (!b){
                    throw new RuntimeException("temp文件夹创建失败");
                }
            }
        }
        //拿到上次上传的图片文件
        String rawImgs = info.getRawImg();
        //切割字符串
        String[] rawStrs = rawImgs.split(" ");
        for (String s : rawStrs) {
            try {
                File from = new File(FileConst.REAL_FILE_PREFIX+s);
                File to = new File(FileConst.TEMP_FILE_PREFIX+s);
                //原上传图片复制到临时文件夹
                FileSystemUtils.copyRecursively(from,to);
                //删除正式文件夹下面的图片
                FileSystemUtils.deleteRecursively(from);
            } catch (IOException e) {
                throw new RuntimeException("文件复制错误！");
            }
        }
        // 将goods中饿goodsImgs转换成数组
        String[] imgs = info.getGoodsImgs().split(" ");
        // 取出数组中的每个元素对应的图片并保存到服务器中
        for (String img : imgs) {
            // 取出上传原图片的文件路径
            String oldImgPath = FileConst.TEMP_FILE_PREFIX + img;
            // 设置新的上传图片路径
            String newImgPath = FileConst.REAL_FILE_PREFIX + img;
            //将图片从临时文件夹移动到正式文件夹
            try {
                log.info("开始移动图片！{}->{}",oldImgPath,newImgPath);
                FileSystemUtils.copyRecursively(new File(oldImgPath),new File(newImgPath));
                log.info("图片移动成功！");
            } catch (IOException e) {
                log.error("保存图片失败！可能的原因：原图片已被删除，更多信息：{}",e.getMessage());
            }
        }
        //清空临时文件夹
        log.info("开始清空临时文件夹！");
        FileSystemUtils.deleteRecursively(new File(FileConst.TEMP_FILE_PREFIX));
        log.info("临时文件夹清空成功！");

        log.info("开始更新商品参数信息！");
        //拿到info的参数items，将商品参数存入数据库表中
        for (GoodsAddInfo.AttrItem attrItem : info.getAttrs()) {
            goodsMapper.updateGoodsAttributes(goods.getGoodsId(),attrItem.getAttrId(),attrItem.getAttrVals());
        }
        log.info("商品参数信息更新成功！");
        log.info("已完成");

    }

    @Override
    public Page<Goods> findGoodsByCondition(GoodsQuery query) {
        if (query == null) {return null;}
        if (query.getCateId() == null || query.getCateLevel()==null) {
            query.setCateId(1);
            query.setCateLevel(0);
        }
        List<Integer> bottomCateIds = cateService.findBottomChildrenByCateId(query.getCateId(),query.getCateLevel());
        Page<Goods> page1 = new Page<>(query.getPage(),query.getSize());
        QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
        if (bottomCateIds != null && bottomCateIds.size() > 0) {
            // 含有子分类
            queryWrapper.in("goods_cate",bottomCateIds);
        } else{
            // 没有子分类，意味着同时也没有商品
            return page1;
        }
        if(!StringUtils.isNullOrEmpty(query.getGoodsName())){
            queryWrapper.like("goods_name",query.getGoodsName());
        }
        if(query.getStartTime()!=null){
            queryWrapper.ge("goods_create",query.getStartTime());
        }
        if(query.getEndTime()!=null){
            queryWrapper.le("goods_create",query.getEndTime());
        }
        queryWrapper.orderByDesc("goods_create");
        return goodsMapper.selectPage(page1,queryWrapper);
    }

    /**
     * 根据商品id查询商品参数信息
     * @param id
     * @return
     */
    @Override
    public List<GoodsAddInfo.AttrItem> getGoodsAttributes(Integer id) {
        return goodsMapper.selectGoodsAttributes(id);
    }
}
