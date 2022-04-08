package com.cc.shoppingnet_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * 定义标准的响应格式
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StandardResp {

    private Map<String,String> meta = new HashMap<>();
    private Map<String,Object> data = new HashMap<>();

    public static StandardResp getOKResp(String message){
        return new StandardResp().addMeta("status","OK").addMeta("msg",message);
    }

    public static StandardResp getErrorResp(String errorMsg){
        return new StandardResp().addMeta("status","ERROR").addMeta("msg",errorMsg);
    }

    public void addData(String key,Object value){
        data.put(key,value);
    }

    public StandardResp addMeta(String key,String value){
        meta.put(key,value);
        return this;
    }
    public void setMessage(String message){
        this.meta.put("message",message);
    }

    public void setStatus(String status){
        this.meta.put("status",status);
    }
}
