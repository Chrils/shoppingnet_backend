package com.cc.shoppingnet_backend.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis plus 相关配置类
 */
@Configuration
public class MPConfig {

    /**
     * 整合Mybatis Plus分页插件
     * 新版本后应当使用 MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //创建mybatis分页拦截器
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
        //加入到总拦截器中
        mybatisPlusInterceptor.addInnerInterceptor(innerInterceptor);
        return mybatisPlusInterceptor;
    }

}
