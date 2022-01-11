package com.lzy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("com.lzy.mapper")
@SpringBootApplication
public class TkmybatisDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(TkmybatisDemo1Application.class, args);
    }

}
