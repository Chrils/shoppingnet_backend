package com.cc.shoppingnet_backend.pojo.info;

import com.cc.shoppingnet_backend.pojo.Cate;
import com.cc.shoppingnet_backend.pojo.tree.CateTree;
import lombok.Data;

import java.util.List;

@Data
public class CateInfo {
    private Integer cateId;
    private String cateName;
    private Integer catePid;
    private Integer cateLevel;
    private Integer cateDeleted;
    private List<Cate> children;
}
