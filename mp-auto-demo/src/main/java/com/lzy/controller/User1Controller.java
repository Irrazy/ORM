package com.lzy.controller;


import com.lzy.pojo.User1;
import com.lzy.service.impl.User1ServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzy
 * @since 2021-12-16
 */
@RestController
@RequestMapping("/user1")
public class User1Controller {
    @Resource
    private User1ServiceImpl user1ServiceImpl;

    @RequestMapping("/all")
    public List<User1> getAll(){
        return user1ServiceImpl.list();
    }

}
