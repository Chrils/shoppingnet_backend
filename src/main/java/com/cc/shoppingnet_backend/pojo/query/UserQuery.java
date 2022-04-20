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

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private String address;

    private Integer userType;

}
