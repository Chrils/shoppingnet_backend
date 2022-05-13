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
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 
     */
    @TableId(value = "addr_id",type = IdType.AUTO)
    private Integer addrId;

    /**
     * 
     */
    private Integer addrUser;

    /**
     * 
     */
    private String addrRealname;

    /**
     * 
     */
    private String addrTelephone;

    /**
     * 
     */
    private String addrProvince;

    /**
     * 
     */
    private String addrCity;

    /**
     * 
     */
    private String addrArea;

    /**
     * 
     */
    private String addrStreet;

    /**
     * 
     */
    private String addrZip;

    /**
     * 
     */
    private Integer addrDefault;

    /**
     * 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addrCreate;

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
        Address other = (Address) that;
        return (this.getAddrId() == null ? other.getAddrId() == null : this.getAddrId().equals(other.getAddrId()))
            && (this.getAddrUser() == null ? other.getAddrUser() == null : this.getAddrUser().equals(other.getAddrUser()))
            && (this.getAddrRealname() == null ? other.getAddrRealname() == null : this.getAddrRealname().equals(other.getAddrRealname()))
            && (this.getAddrTelephone() == null ? other.getAddrTelephone() == null : this.getAddrTelephone().equals(other.getAddrTelephone()))
            && (this.getAddrProvince() == null ? other.getAddrProvince() == null : this.getAddrProvince().equals(other.getAddrProvince()))
            && (this.getAddrCity() == null ? other.getAddrCity() == null : this.getAddrCity().equals(other.getAddrCity()))
            && (this.getAddrArea() == null ? other.getAddrArea() == null : this.getAddrArea().equals(other.getAddrArea()))
            && (this.getAddrStreet() == null ? other.getAddrStreet() == null : this.getAddrStreet().equals(other.getAddrStreet()))
            && (this.getAddrZip() == null ? other.getAddrZip() == null : this.getAddrZip().equals(other.getAddrZip()))
            && (this.getAddrDefault() == null ? other.getAddrDefault() == null : this.getAddrDefault().equals(other.getAddrDefault()))
            && (this.getAddrCreate() == null ? other.getAddrCreate() == null : this.getAddrCreate().equals(other.getAddrCreate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddrId() == null) ? 0 : getAddrId().hashCode());
        result = prime * result + ((getAddrUser() == null) ? 0 : getAddrUser().hashCode());
        result = prime * result + ((getAddrRealname() == null) ? 0 : getAddrRealname().hashCode());
        result = prime * result + ((getAddrTelephone() == null) ? 0 : getAddrTelephone().hashCode());
        result = prime * result + ((getAddrProvince() == null) ? 0 : getAddrProvince().hashCode());
        result = prime * result + ((getAddrCity() == null) ? 0 : getAddrCity().hashCode());
        result = prime * result + ((getAddrArea() == null) ? 0 : getAddrArea().hashCode());
        result = prime * result + ((getAddrStreet() == null) ? 0 : getAddrStreet().hashCode());
        result = prime * result + ((getAddrZip() == null) ? 0 : getAddrZip().hashCode());
        result = prime * result + ((getAddrDefault() == null) ? 0 : getAddrDefault().hashCode());
        result = prime * result + ((getAddrCreate() == null) ? 0 : getAddrCreate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", addrId=").append(addrId);
        sb.append(", addrUser=").append(addrUser);
        sb.append(", addrRealname=").append(addrRealname);
        sb.append(", addrTelephone=").append(addrTelephone);
        sb.append(", addrProvince=").append(addrProvince);
        sb.append(", addrCity=").append(addrCity);
        sb.append(", addrArea=").append(addrArea);
        sb.append(", addrStreet=").append(addrStreet);
        sb.append(", addrZip=").append(addrZip);
        sb.append(", addrDefault=").append(addrDefault);
        sb.append(", addrCreate=").append(addrCreate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}