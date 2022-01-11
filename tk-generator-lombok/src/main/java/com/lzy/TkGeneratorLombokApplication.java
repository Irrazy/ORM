package com.lzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.lzy.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TkGeneratorLombokApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkGeneratorLombokApplication.class, args);
    }

}
