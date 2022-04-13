package com.cc.shoppingnet_backend.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery {

//    private Integer pageNo;
//
//    private Integer pageSize;

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String address;

    private Integer userType;

    /*public void setPageNo(String pageNo) {
        try {
            this.pageNo = pageNo == null ? 1 : Integer.parseInt(pageNo);
        } catch (NumberFormatException e) {
            this.pageNo = 1;
        }
    }

    public void setPageSize(String pageSize) {
        try {
            this.pageSize = pageSize == null ? 10 : Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            this.pageSize = 10;
        }
    }*/

}
