package com.cc.shoppingnet_backend.pojo.item;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName order_item
 */
@TableName(value ="order_item")
@Data
public class OrderItem implements Serializable {
    /**
     * 
     */
    @TableId(value = "item_id",type = IdType.AUTO)
    private Integer itemId;

    /**
     * 
     */
    private Integer itemOrder;

    /**
     * 
     */
    private Integer itemCount;

    /**
     * 
     */
    private Integer itemGoodsId;

    /**
     * 
     */
    private String itemGoodsName;

    /**
     * 
     */
    private Integer itemNumber;

    /**
     * 
     */
    private BigDecimal itemGoodsPrice;

    private String itemImgUrl;

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
        OrderItem other = (OrderItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemOrder() == null ? other.getItemOrder() == null : this.getItemOrder().equals(other.getItemOrder()))
            && (this.getItemCount() == null ? other.getItemCount() == null : this.getItemCount().equals(other.getItemCount()))
            && (this.getItemGoodsId() == null ? other.getItemGoodsId() == null : this.getItemGoodsId().equals(other.getItemGoodsId()))
            && (this.getItemGoodsName() == null ? other.getItemGoodsName() == null : this.getItemGoodsName().equals(other.getItemGoodsName()))
            && (this.getItemNumber() == null ? other.getItemNumber() == null : this.getItemNumber().equals(other.getItemNumber()))
            && (this.getItemGoodsPrice() == null ? other.getItemGoodsPrice() == null : this.getItemGoodsPrice().equals(other.getItemGoodsPrice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemOrder() == null) ? 0 : getItemOrder().hashCode());
        result = prime * result + ((getItemCount() == null) ? 0 : getItemCount().hashCode());
        result = prime * result + ((getItemGoodsId() == null) ? 0 : getItemGoodsId().hashCode());
        result = prime * result + ((getItemGoodsName() == null) ? 0 : getItemGoodsName().hashCode());
        result = prime * result + ((getItemNumber() == null) ? 0 : getItemNumber().hashCode());
        result = prime * result + ((getItemGoodsPrice() == null) ? 0 : getItemGoodsPrice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", itemOrder=").append(itemOrder);
        sb.append(", itemCount=").append(itemCount);
        sb.append(", itemGoodsId=").append(itemGoodsId);
        sb.append(", itemGoodsName=").append(itemGoodsName);
        sb.append(", itemNumber=").append(itemNumber);
        sb.append(", itemGoodsPrice=").append(itemGoodsPrice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}