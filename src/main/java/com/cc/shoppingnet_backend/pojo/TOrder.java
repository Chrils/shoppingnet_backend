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
public class TOrder {
    @TableId(value = "order_id",type = IdType.AUTO)
    private Integer orderId; //订单id
    private String orderNo; //订单编号
    private Integer orderUserId; //订单用户Id
    private Integer orderAddressId; //订单地址Id
    private String orderAddress; //订单地址
    private String orderUsername; //订单收货人

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderCreateTime; //订单创建时间

    private Integer orderItemCount; //订单项数量
    private BigDecimal orderTotal; //订单总金额
    private BigDecimal orderFee; //订单运费
    private Integer orderShop; //订单店铺Id
    private Integer orderStatus; //订单状态

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderPayTime; //订单支付时间

    private String orderRemark; //订单备注

}
