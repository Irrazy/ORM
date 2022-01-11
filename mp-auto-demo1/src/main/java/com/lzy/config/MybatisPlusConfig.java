package com.lzy.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: mp-auto-demo1
 * @description: config
 * @author: 作者
 * @create: 2021-12-17 10:07
 */
//Spring boot方式
@MapperScan("com.lzy.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    //分页插件--配置拦截器组件

    /**
     *
     * @Bean
     *     public MybatisPlusInterceptor mybatisPlusInterceptor() {
     *         MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
     *         interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
     *         return interceptor;
     *     }
     *
     * @return
     */


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        // paginationInterceptor.setLimit(500);
        return paginationInterceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        // 函数式编程
        return (configuration) -> {
            // 使用mybatis-plus 内置的
            configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
        };
    }


}
