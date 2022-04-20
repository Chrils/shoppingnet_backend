package com.cc.shoppingnet_backend.pojo.tree;

import com.cc.shoppingnet_backend.pojo.Cate;
import lombok.Data;

import java.util.List;

@Data
public class CateTree extends Cate {
    private List<CateTree> children;
//    private Integer maxLevel;
}
