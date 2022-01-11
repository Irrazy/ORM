package com.lzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzy.mapper")
public class MpAutoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpAutoDemoApplication.class, args);
    }

}
