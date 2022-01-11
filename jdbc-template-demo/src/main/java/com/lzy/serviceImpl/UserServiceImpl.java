package com.lzy.serviceImpl;

import com.lzy.pojo.User;
import com.lzy.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: jdbc-template-demo
 * @description: UserServiceImpl
 * @author: 作者
 * @create: 2021-12-23 17:17
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private JdbcTemplate jdbcTemplate;
    //增
    @Override
    public String insert(User user) {
        //update 方法的返回值就是 SQL 执行受影响的行数
        int count = jdbcTemplate.update("insert into user1(account,password) values(?,?)" ,user.getAccount(),user.getPassword());
        if (count>0){
            return "sucessful";
        }else {
            return "erro";
        }

    }

    //批量插入


}
