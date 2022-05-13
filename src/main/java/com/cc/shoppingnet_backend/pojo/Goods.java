package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cc.shoppingnet_backend.annotation.StandardDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods {
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;
    private String goodsName;
    private String goodsDesc;
    private BigDecimal goodsPrice;
    private Integer goodsStock;
    private String goodsImgs;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date goodsCreate;
    private Integer goodsCate;
    private Double goodsWeight;
    private Integer goodsSell;
}
