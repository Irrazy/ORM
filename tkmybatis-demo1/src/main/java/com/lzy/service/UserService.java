package com.lzy.service;

import com.lzy.pojo.User;

import java.util.List;

public interface UserService {
    //增
      //int insert(User user);
    int insertSelective(User user);
    //批量插入和批量查询及批量插入都不能用，因为 dao 层的 mapper 接口还要继承 MySqlMapper

    //删--先删再调用查所有
    int delete(Long id);
    //将实体中set不为空的字段作为删除条件，默认以and连接这些字段条件
    int deleteMapper(User user);

    //改
    int updateByPrimaryKey(User user);
    int updateByPrimaryKeySelective(User user);


    //查
    List<User> selectAll();

    User findById(Long id);

    List<User> selectExample(User user);//自定义条件查询



}
