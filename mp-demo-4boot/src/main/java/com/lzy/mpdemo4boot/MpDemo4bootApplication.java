package com.lzy.mpdemo4boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzy.mpdemo4boot.mapper")
public class MpDemo4bootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpDemo4bootApplication.class, args);
    }



}
