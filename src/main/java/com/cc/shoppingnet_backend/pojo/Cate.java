package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Cate {
    @TableId
    private Integer cateId;
    private String cateName;
    private Integer catePid;
    private Integer cateLevel;
    private Integer cateDeleted;
}
