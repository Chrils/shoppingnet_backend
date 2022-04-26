package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * 权限表实体类
 */
@Data
@ToString
public class TRight {
    @TableId(value = "right_id", type = IdType.AUTO)
    private Integer rightId;
    private String rightName;
    private String rightUrl;
    private Integer rightPid;
    private Integer rightLevel;
    private String description;
}
