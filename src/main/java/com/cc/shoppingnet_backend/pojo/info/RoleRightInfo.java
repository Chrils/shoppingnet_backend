package com.cc.shoppingnet_backend.pojo.info;

import com.cc.shoppingnet_backend.pojo.tree.TRightTree;
import lombok.Data;

import java.util.List;

@Data
public class RoleRightInfo {
    private int roleId;
    private String roleName;
    private String roleDesc;
    private List<TRightTree> rightTreeList;
}
