package com.cc.shoppingnet_backend.pojo.tree;

import com.cc.shoppingnet_backend.pojo.Cate;
import lombok.Data;

import java.util.List;

@Data
public class CateTreeTemp extends Cate {
    private List<Cate> children;
//    private Integer maxLevel;
}
