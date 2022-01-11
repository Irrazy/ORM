package com.lzy.mpdemo4boot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.mpdemo4boot.mapper.UserMapper;
import com.lzy.mpdemo4boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mp-demo-4boot
 * @description: test
 * @author: 作者
 * @create: 2021-12-14 17:54
 */
@SpringBootTest
public class MpDemo4bootApplicationTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> list1 = userMapper.selectList(null);
        list1.forEach(System.out::println);
    }


    //增-插入一个用户
    @Test
    void testInsert(){
        int result=userMapper.insert(new User(null,"李四","123123123"));
        System.out.println("result"+result);
    }


    //删-删除用户byId
    @Test
    void testDeleteById(){
       int result= userMapper.deleteById(0);
        System.out.println(result);
    }

    //删除account="直护",password="000111"的用户
    @Test
    void testDeleteByMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("account","直护");
        map.put("password","000111");
        int result=userMapper.deleteByMap(map);
        System.out.println(result);
    }

    //删除id=4,5,6的三位用户
    @Test
    void testDeleteBatchIds(){
         int result= userMapper.deleteBatchIds(Arrays.asList(4,5,6));
        System.out.println(result);
    }


    //改--修改用户·信息ById
    @Test
    void tsetUpdateById(){
        //先查询
        User user1=userMapper.selectById(7);
        user1.setPassword("000111");
        //再修改
        int result=userMapper.updateById(user1);
        System.out.println(result);

    }


    //查询id为1的用户
    @Test
    void testSelectById() {
        User user = userMapper.selectById(3);
        System.out.println(user);
    }

    //查询account="直护",password="000111"的用户信息
    @Test
    //通用查询操作 selectByMap  map要写列名条件 不能是实体属性名
    void testSelectByMap(){
        //新建一个map,放入要查询的两组信息
        Map<String,Object>map=new HashMap<>();
        map.put("account","直护");
        map.put("password","000111");
        //返回类型是List
        List<User> list1=userMapper.selectByMap(map);
        //函数式编程，是其缩写形式
        list1.forEach(System.out::println);
    }

    //查询id分别为4、5、6的用户信息
    @Test
    //通用查询操作 selectBatchIds 通过多个ID进行查询
    void testSelectBatchIds(){
        /**
         * selectBatchIds(param)方法中的参数是一个数组，装id的数组
         * 这个数组参数可以采用两种方式来写
         * 1.Arrays.asList(4,5,6)----简单写法
         * 2.先创建List<Integer> list1 = newArrayList<Integer>()数组，再list1.add(4)向组内添加;
         */

        List<User> list1 =userMapper.selectBatchIds(Arrays.asList(4,5,6));
        list1.forEach(System.out::println);
    }

    //分页查询
    @Test
    void testSelectByPage() {
        Page<User> page =  new Page<>(2,3);
        Page<User> userPage = userMapper.selectPage(page,null);
        List<User> list1 = userPage.getRecords();
        list1.forEach(System.out::println);
        System.out.println("当前页：" + userPage.getCurrent());
        System.out.println("总页数：" + userPage.getPages());
        System.out.println("记录数：" + userPage.getTotal());
        System.out.println("是否有上一页：" + userPage.hasPrevious());
        System.out.println("是否有下一页：" + userPage.hasNext());

    }


}
