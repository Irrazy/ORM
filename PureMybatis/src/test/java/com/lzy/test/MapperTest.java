package com.lzy.test;

import com.lzy.mapper.UserMapper;
import com.lzy.pojo.User;
import com.lzy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @program: PureMybatis
 * @description: mapperTest
 * @author: 作者
 * @create: 2021-12-14 17:07
 */
public class MapperTest {
    //数据库连接
    private SqlSession session;
    //mapper接口
    private UserMapper userMapper;

    @Before
    public void init(){
        //利用MyBatisUtil工具类获取数据库的连接
        session = MyBatisUtil.openSession();
        //获取到UserMapper的接口
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory(){
        //关闭连接
        session.close();
    }

    @Test
    public void findUserList(){
        List<User> userList = userMapper.findUserList();
        System.out.println(userList);
    }





}
