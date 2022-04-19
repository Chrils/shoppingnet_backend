package com.cc.shoppingnet_backend.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * 权限表实体类
 */
@Data
@ToString
public class TRight {
    private Integer rightId;
    private String rightName;
    private String rightUrl;
    private Integer rightPid;
    private Integer rightLevel;
    private String description;
}
