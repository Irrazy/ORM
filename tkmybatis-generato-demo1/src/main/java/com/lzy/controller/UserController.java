package com.lzy.controller;

import com.lzy.pojo.User;
import com.lzy.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tkmybatis-generato-demo1
 * @description: userController
 * @author: 作者
 * @create: 2021-12-23 13:43
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        List<User> list1=userServiceImpl.selectAll();
        list1.forEach(System.out::println);
        return list1;
    }

    @RequestMapping("/findId")
    public User findById(){
        User user=userServiceImpl.findById(25L);
        System.out.println(user);
        return  user;
    }

    @RequestMapping("/insert")
    public String insert(User user){
        //user.setId(null);
        user.setAccount("Lily");
        user.setPassword("678976");
        int a=userServiceImpl.insertSelective(user);
        //int a=userServiceImpl.insert(user);
        System.out.println(a); //成功的话a的值是1
        return  "sucessful";
    }

    @RequestMapping("/updateByPrimaryKey")
    public String updateByPrimaryKey(){
        User user1=userServiceImpl.findById(27L);
        user1.setAccount("Lily4");
        user1.setPassword("0000");
        int a = userServiceImpl.updateByPrimaryKey(user1);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }
    }

    @RequestMapping("/deleteById")
    public String deleteById(){
        int a = userServiceImpl.delete(32L);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }

    }





}
