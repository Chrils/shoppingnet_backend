package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cate {
    // 自增主键
    @TableId(value = "cate_id",type = IdType.AUTO)
    private Integer cateId;
    private String cateName;
    private Integer catePid;
    private Integer cateLevel;
    private Integer cateDeleted;
}
