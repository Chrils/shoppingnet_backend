package com.cc.shoppingnet_backend.annotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.core.annotation.AliasFor;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.annotation.*;

/**
 * 定义一个注解，用于标注日期类型的字段，并定义日期的格式
 * @author CC
 * TODO 无效
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JsonFormat
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public @interface StandardDate {
    @AliasFor(annotation = JsonFormat.class)
    String pattern() default "yyyy-MM-dd HH:mm:ss";
    String timezone() default "GMT+8";
}

