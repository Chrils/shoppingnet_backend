package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.cc.shoppingnet_backend.annotation.StandardDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName logistics
 */
@TableName(value ="logistics")
@Data
public class Logistics implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer logisticsId;

    /**
     * 
     */
    private Integer orderId;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date logisticsTime;

    /**
     * 
     */
    private String logisticsDesc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Logistics other = (Logistics) that;
        return (this.getLogisticsId() == null ? other.getLogisticsId() == null : this.getLogisticsId().equals(other.getLogisticsId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getLogisticsTime() == null ? other.getLogisticsTime() == null : this.getLogisticsTime().equals(other.getLogisticsTime()))
            && (this.getLogisticsDesc() == null ? other.getLogisticsDesc() == null : this.getLogisticsDesc().equals(other.getLogisticsDesc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogisticsId() == null) ? 0 : getLogisticsId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getLogisticsTime() == null) ? 0 : getLogisticsTime().hashCode());
        result = prime * result + ((getLogisticsDesc() == null) ? 0 : getLogisticsDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", logisticsId=").append(logisticsId);
        sb.append(", orderId=").append(orderId);
        sb.append(", logisticsTime=").append(logisticsTime);
        sb.append(", logisticsDesc=").append(logisticsDesc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}