package com.cc.shoppingnet_backend.utils;

import org.springframework.beans.BeanUtils;

public class EntityUtils {

    /**
     * 将实体类A的属性值赋值给实体类B
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }



}
