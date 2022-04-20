package com.cc.shoppingnet_backend.pojo.tree;

import com.cc.shoppingnet_backend.pojo.TRight;
import lombok.Data;

import java.util.List;

@Data
public class TRightTree extends TRight {
    private List<TRight> children;
}
