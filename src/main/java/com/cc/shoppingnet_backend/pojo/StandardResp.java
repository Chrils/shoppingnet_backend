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

    /**
     * 获取一个成功的响应模板
     * @param message
     * @return
     */
    public static StandardResp getOKResp(String message){
        return new StandardResp().addMeta("status","OK").addMeta("msg",message);
    }

    /**
     * 获取一个失败的响应模板
     * @param errorMsg
     * @return
     */
    public static StandardResp getErrorResp(String errorMsg){
        return new StandardResp().addMeta("status","ERROR").addMeta("msg",errorMsg);
    }

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void addData(String key,Object value){
        data.put(key,value);
    }

    /**
     * 添加meta
     * @param key
     * @param value
     * @return
     */
    public StandardResp addMeta(String key,String value){
        meta.put(key,value);
        return this;
    }

    /**
     * 向meta中添加一个响应信息
     * @param message
     */
    public void setMessage(String message){
        this.meta.put("message",message);
    }

    /**
     * 向meta中添加一个响应状态
     * @param status
     */
    public void setStatus(String status){
        this.meta.put("status",status);
    }
}
