package com.lzy.controller;

import com.lzy.pojo.User;
import com.lzy.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tkmybatis-demo1
 * @description: userController
 * @author: 作者
 * @create: 2021-12-20 14:57
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/findId")
    public User findById(){
        User user=userServiceImpl.findById(13L);
        System.out.println(user);
        return  user;
    }

    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        List<User> list1=userServiceImpl.selectAll();
        System.out.println(list1);
        return list1;
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


    //自定义条件搜索1
    @RequestMapping("/selectExample")
    public List<User> selectExample(User user){
        user.setAccount("Rubby");
        user.setPassword("456");
        List<User> list1 = userServiceImpl.selectExample(user);
        System.out.println(list1);
        return list1;
    }

    @RequestMapping("/deleteById")
    public String deleteById(){
        int a = userServiceImpl.delete(31L);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }

    }

    @RequestMapping("/deleteMapper")
    public String deleteMapper(User user){
        user.setAccount("Tom");
        user.setPassword("122343");
        int a = userServiceImpl.deleteMapper(user);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }
    }

    @RequestMapping("/updateByPrimaryKey")
    public String updateByPrimaryKey(){
        User user1=userServiceImpl.findById(27L);
        user1.setAccount("Lily3");
        user1.setPassword("122343");
        int a = userServiceImpl.updateByPrimaryKey(user1);
        System.out.println(a);
        if(a==1){
            return  "sucessful";
        }else{
            return  "erro";
        }
    }


}
