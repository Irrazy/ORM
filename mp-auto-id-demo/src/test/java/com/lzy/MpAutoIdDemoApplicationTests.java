package com.lzy;

import com.lzy.mapper.ProductMapper;
import com.lzy.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MpAutoIdDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private ProductMapper productMapper;

    @Test
    void testProductIdGenerator(){
        Product product = new Product();
        product.setPname("apple");
        int result = productMapper.insert(product);
        System.out.println(result);
    }

}
