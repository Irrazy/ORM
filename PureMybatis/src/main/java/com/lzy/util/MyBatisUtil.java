package com.lzy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: PureMybatis
 * @description: MyBatisUtil
 * @author: 作者
 * @create: 2021-12-14 14:27
 */
public class MyBatisUtil {
    //都用了static（静态）的关键字
    //原因：在使用的时候，类加载时就初始化

    private static SqlSessionFactory sessionFactory;

    static {

        try {
            //加载配置文件
            InputStream is = Resources.getResourceAsStream("mybatis.xml");

            //创建sessionFactory对象
            sessionFactory = new SqlSessionFactoryBuilder().build(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取session对象
    public static SqlSession openSession() {
        return sessionFactory.openSession();
    }

}
