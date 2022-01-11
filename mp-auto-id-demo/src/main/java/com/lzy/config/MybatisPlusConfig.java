package com.lzy.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.lzy.incrementer.ProductIdGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: mp-auto-id-demo
 * @description: config
 * @author: 作者
 * @create: 2021-12-17 16:18
 */
@MapperScan("com.lzy.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {
    //id生成器
    @Bean
    public IdentifierGenerator productIdGenerator(){
        return new ProductIdGenerator();
    }


}
