package com.cc.shoppingnet_backend.pojo;

import lombok.Data;

import java.util.List;

@Data
public class TRightTree extends TRight{
    private List<TRight> children;
}
