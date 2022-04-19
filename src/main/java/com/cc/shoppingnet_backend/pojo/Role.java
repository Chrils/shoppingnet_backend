package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

/**
 * 角色实体类
 */
@Data
@ToString
public class Role {
    @TableId
    private Integer roleId;
    private String roleName;
    private String roleDesc;
}
