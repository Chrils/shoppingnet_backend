package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import com.cc.shoppingnet_backend.pojo.item.CartItem;
import lombok.Data;
import lombok.ToString;

/**
 * 
 * @TableName cart
 */
@TableName(value ="cart")
@Data
@ToString
public class Cart implements Serializable {
    /**
     * 
     */
    @TableId(value = "cart_id", type = IdType.AUTO)
    private Integer cartId;

    /**
     * 
     */
    private Integer cartUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private List<CartItem> cartItems;

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
        Cart other = (Cart) that;
        return (this.getCartId() == null ? other.getCartId() == null : this.getCartId().equals(other.getCartId()))
            && (this.getCartUser() == null ? other.getCartUser() == null : this.getCartUser().equals(other.getCartUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCartId() == null) ? 0 : getCartId().hashCode());
        result = prime * result + ((getCartUser() == null) ? 0 : getCartUser().hashCode());
        return result;
    }
}