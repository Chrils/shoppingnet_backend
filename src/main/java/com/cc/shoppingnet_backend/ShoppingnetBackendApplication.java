package com.cc.shoppingnet_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cc.shoppingnet_backend.mapper")
@SpringBootApplication
public class ShoppingnetBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingnetBackendApplication.class, args);
    }

}
