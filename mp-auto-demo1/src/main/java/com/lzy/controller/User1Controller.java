package com.lzy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.pojo.User1;
import com.lzy.service.impl.User1ServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping("/Uid")
    public User1 getById(){
        return user1ServiceImpl.getById(14);
    }

    @RequestMapping("/insert")
    public Boolean insert(User1 user1){
        user1.setAccount("jason");
        user1.setPassword("999000");
        Boolean a=user1ServiceImpl.save(user1);
        return a;
    }


    /**
     * 分页查询
     * @param pageNo 起始页
     * @param pageSize 页数
     * @param user 类
     * @return 返回值
     */
    @GetMapping("/findAllPage")
    public IPage<User1> findAllPage(@RequestParam(name = "pageNo", defaultValue = "2") Integer pageNo,
                                @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize, User1 user){
        QueryWrapper<User1> queryWrapper = new QueryWrapper<>();
        //queryWrapper.lambda().eq(User::getAddress,"北京");
        Page<User1> userPage = new Page<>(pageNo, pageSize);
        IPage<User1> iPage = user1ServiceImpl.page(userPage, queryWrapper);
        return iPage;
    }



}

