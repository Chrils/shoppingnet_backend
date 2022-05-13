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
 * @TableName cart_item
 */
@TableName(value ="cart_item")
@Data
public class CartItem implements Serializable {
    /**
     * 
     */
    @TableId(value = "item_id", type = IdType.AUTO)
    private Integer itemId;

    private Integer itemCart; //购物车id

    private String itemGoodsImage; //商品图片

    private Integer itemGoodsStock; // 商品库存

    /**
     * 
     */
    private Integer itemGoodsId;  //商品id

    /**
     * 
     */
    private BigDecimal itemGoodsPrice;

    /**
     * 
     */
    private String itemGoodsName;

    /**
     * 
     */
    private BigDecimal itemTotal;

    /**
     * 
     */
    private Integer itemGoodsCount;

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
        CartItem other = (CartItem) that;
        return (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
            && (this.getItemGoodsId() == null ? other.getItemGoodsId() == null : this.getItemGoodsId().equals(other.getItemGoodsId()))
            && (this.getItemGoodsPrice() == null ? other.getItemGoodsPrice() == null : this.getItemGoodsPrice().equals(other.getItemGoodsPrice()))
            && (this.getItemGoodsName() == null ? other.getItemGoodsName() == null : this.getItemGoodsName().equals(other.getItemGoodsName()))
            && (this.getItemTotal() == null ? other.getItemTotal() == null : this.getItemTotal().equals(other.getItemTotal()))
            && (this.getItemGoodsCount() == null ? other.getItemGoodsCount() == null : this.getItemGoodsCount().equals(other.getItemGoodsCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getItemGoodsId() == null) ? 0 : getItemGoodsId().hashCode());
        result = prime * result + ((getItemGoodsPrice() == null) ? 0 : getItemGoodsPrice().hashCode());
        result = prime * result + ((getItemGoodsName() == null) ? 0 : getItemGoodsName().hashCode());
        result = prime * result + ((getItemTotal() == null) ? 0 : getItemTotal().hashCode());
        result = prime * result + ((getItemGoodsCount() == null) ? 0 : getItemGoodsCount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", itemId=").append(itemId);
        sb.append(", itemGoodsId=").append(itemGoodsId);
        sb.append(", itemGoodsPrice=").append(itemGoodsPrice);
        sb.append(", itemGoodsName=").append(itemGoodsName);
        sb.append(", itemTotal=").append(itemTotal);
        sb.append(", itemGoodsCount=").append(itemGoodsCount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}