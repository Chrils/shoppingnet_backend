package com.cc.shoppingnet_backend.pojo.info;

import com.cc.shoppingnet_backend.pojo.tree.CateTreeTemp;
import lombok.Data;

import java.util.List;

@Data
public class CateInfo {
    List<CateTreeTemp> cateTreeList;
}
