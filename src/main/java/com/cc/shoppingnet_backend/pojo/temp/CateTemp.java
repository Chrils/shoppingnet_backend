package com.cc.shoppingnet_backend.pojo.temp;

import com.cc.shoppingnet_backend.pojo.Cate;
import lombok.Data;

import java.util.List;

@Data
public class CateTemp {
    private Integer cateId;
    private String cateName;
    private Integer catePid;
    private Integer cateLevel;
    private Integer cateDeleted;
    private List<Cate> children;
}
