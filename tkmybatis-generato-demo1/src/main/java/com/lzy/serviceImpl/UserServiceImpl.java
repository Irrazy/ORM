package com.lzy.serviceImpl;

import com.lzy.mapper.UserMapper;
import com.lzy.pojo.User;
import com.lzy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tkmybatis-generato-demo1
 * @description: UserServiceimpl
 * @author: 作者
 * @create: 2021-12-23 11:53
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    //查一个ById
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    //增加一个

    @Override
    public int insertSelective(User user) {
        //用insertSelective不会给没有赋值的字段插入null值，有些字段有默认值就要用这个方法
        return userMapper.insertSelective(user);
    }

    //先查出来一个实体（ById）再更新
    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user); //根据主键字段准确地修改某一条记录。---update table set 所有字段
    }

    //删除
    //ById
    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}

