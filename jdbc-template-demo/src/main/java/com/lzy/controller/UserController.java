package com.lzy.controller;

import com.lzy.pojo.User;
import com.lzy.serviceImpl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: jdbc-template-demo
 * @description: userController
 * @author: 作者
 * @create: 2021-12-23 17:18
 */
@RestController
@RequestMapping("/jdbc")
public class UserController {
    @Resource
    UserServiceImpl userServiceImpl;

    @RequestMapping("/insert")
    public String insert(User user){
        user.setAccount("piyu");
        user.setPassword("898989");
        return userServiceImpl.insert(user);
    }
}
