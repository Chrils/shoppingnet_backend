package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 表示商品参数的实体类
 */
@Data
public class Attribute {
    @TableId(value = "attr_id",type = IdType.AUTO)
    private Integer attrId;
    private Integer cateId;
    private String attrName;
    private String attrSel;
    private String attrWrite;
    private String attrVals;
}
