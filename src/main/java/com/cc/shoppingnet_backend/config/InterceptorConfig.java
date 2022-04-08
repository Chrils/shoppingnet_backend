package com.cc.shoppingnet_backend.config;

import com.cc.shoppingnet_backend.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加JWTInterceptor拦截器
        registry.addInterceptor(new JWTInterceptor())
//                .addPathPatterns("/user/**","/client/**","/admin/**")
                .addPathPatterns("/**")
                .excludePathPatterns("/client/user/login");
    }
}
