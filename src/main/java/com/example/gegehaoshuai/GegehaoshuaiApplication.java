package com.example.gegehaoshuai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.woniuxy"})
@MapperScan("com.woniuxy.dao")
public class GegehaoshuaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GegehaoshuaiApplication.class, args);
    }

}
