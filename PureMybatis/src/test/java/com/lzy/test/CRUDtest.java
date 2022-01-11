package com.lzy.test;

import com.lzy.pojo.User;
import com.lzy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: PureMybatis
 * @description: crudTest
 * @author: 作者
 * @create: 2021-12-14 15:06
 */
public class CRUDtest {
    private SqlSession session;

    @Before
    public void init(){
        //利用MyBatisUtil工具类获取数据库的连接
        session = MyBatisUtil.openSession();
    }

    @After
    public void destory(){
        //关闭连接
        session.close();
    }

    //不带参数的查询
    @Test
    public void findUserListTest(){
        //session.selectList("namespace属性值.sql语言id值")
        List<User> list1= session.selectList("usermapper.findUserList");
        System.out.println(list1);
    }

    //带一个参数
    @Test
    public void findUserById(){
        int id=7;
        User user1 = session.selectOne("usermapper.findUserById",id);
        System.out.println(user1);
    }

    //实现分页效果
    @Test
    public void findUserByPage(){
        //从第四条数据开始取，索引为3，取size三条
        //pgsql分页不同语法：select * from public.user  param1  offset param2 ; // 从（param2+1）条数据开始，取 param1条数据
        int currentPage=3;
        int pageSize=3;
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageSize",pageSize);
        map.put("currentPage",currentPage);
        System.out.println("pageSize:"+map.get("pageSize"));
        System.out.println("currentPage:"+map.get("currentPage"));
        List<User> userList = session.selectList("usermapper.findUserByPage", map);
        System.out.println(userList);
        System.out.println("当前查询数据从第："+(currentPage+1)+"条，到"+"第:"+(currentPage+1+pageSize)+"条");


    }




}
