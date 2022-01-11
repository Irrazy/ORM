package com.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.lzy.mapper")
@SpringBootApplication
public class TkmybatisGeneratoDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(TkmybatisGeneratoDemo1Application.class, args);
    }

}
