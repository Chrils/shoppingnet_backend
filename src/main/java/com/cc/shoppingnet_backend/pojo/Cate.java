package com.cc.shoppingnet_backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cate
 */
@TableName(value ="cate")
@Data
public class Cate implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer cateId;

    /**
     * 
     */
    private Integer catePid;

    /**
     * 
     */
    private Integer cateLevel;

    /**
     * 
     */
    private String cateName;

    /**
     * 分类是否可用 0(默认可用) 1不可用
     */
    private Boolean cateDeleted;

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
        Cate other = (Cate) that;
        return (this.getCateId() == null ? other.getCateId() == null : this.getCateId().equals(other.getCateId()))
            && (this.getCatePid() == null ? other.getCatePid() == null : this.getCatePid().equals(other.getCatePid()))
            && (this.getCateLevel() == null ? other.getCateLevel() == null : this.getCateLevel().equals(other.getCateLevel()))
            && (this.getCateName() == null ? other.getCateName() == null : this.getCateName().equals(other.getCateName()))
            && (this.getCateDeleted() == null ? other.getCateDeleted() == null : this.getCateDeleted().equals(other.getCateDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCateId() == null) ? 0 : getCateId().hashCode());
        result = prime * result + ((getCatePid() == null) ? 0 : getCatePid().hashCode());
        result = prime * result + ((getCateLevel() == null) ? 0 : getCateLevel().hashCode());
        result = prime * result + ((getCateName() == null) ? 0 : getCateName().hashCode());
        result = prime * result + ((getCateDeleted() == null) ? 0 : getCateDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cateId=").append(cateId);
        sb.append(", catePid=").append(catePid);
        sb.append(", cateLevel=").append(cateLevel);
        sb.append(", cateName=").append(cateName);
        sb.append(", cateDeleted=").append(cateDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}