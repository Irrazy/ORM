package com.lzy.mpdemo4boot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.lzy.mpdemo4boot.mapper.UserMapper;
import com.lzy.mpdemo4boot.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mp-demo-4boot
 * @description: mp查询条件构造器test
 * @author: 作者
 * @create: 2021-12-15 14:59
 */
@SpringBootTest
public class MpDemo4bootApplicationTestEW {
    @Resource
    private UserMapper userMapper;

    /*
    1.带条件的查询
     */
          //查询用户名包含L，且密码为1234567
    @Test
    void testSelectList1(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper
                .like("account","L")      //like:模糊匹配
                .eq("password","1234567");   //eq；等同于   ；gt:大于/ lt:小于
        List<User> list1 = userMapper.selectList(queryWrapper);
        list1.forEach(System.out::println);
    }

    //查询所有用户信息
    @Test
    void testSelectList2(){
        List<User> list1 = userMapper.selectList(null);
        list1.forEach(System.out::println);
    }

    //查询所有account中带有T的用户的数量
    @Test
    void testSelectList3(){
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.like("account","T");
        Integer account = userMapper.selectCount(queryWrapper);
        System.out.println(account);
    }

    /*
    **********************************************************************************
    **********************************************************************************
     */
    /*
    2.带条件的修改
     */

    //将密码=123456且用户名含有2的用户密码修改为666888     修改只有1个，不是批量
    @Test
    void testUpdate(){
        UpdateWrapper<User> updateWrapper=new UpdateWrapper();
        updateWrapper
                .like("account",2)
                .eq("password","123456")
                ;
        User user=new User();
        user.setPassword("666888");
        userMapper.update(user,updateWrapper);
    }

    /*
     **********************************************************************************
     **********************************************************************************
     */
    /*
    3.带条件的删除
     */

    //将用户姓名带有1的都删除
    @Test
    void testDelete(){
        //先查询
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.like("account",1);
        int result = userMapper.delete(queryWrapper);
        System.out.println(result);
        //再删除


    }



}
