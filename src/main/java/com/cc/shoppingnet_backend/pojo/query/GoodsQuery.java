package com.cc.shoppingnet_backend.pojo.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class GoodsQuery {

    private String goodsName;
    private Integer cateId;
    private Integer cateLevel;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private Integer page;
    private Integer size;
    private Double minPrice;
    private Double maxPrice;
    private Integer minSell;
    private Integer maxSell;
    private Boolean priceDesc;
    private Boolean sellDesc;
}
