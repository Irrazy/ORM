package com.lzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzy.mapper")
public class MpAutoDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MpAutoDemo1Application.class, args);
    }

}
