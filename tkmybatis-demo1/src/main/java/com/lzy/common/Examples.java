package com.lzy.common;

import com.lzy.pojo.User;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: tkmybatis-demo1
 * @description: Examples自定义各类条件构造器
 * @author: 作者
 * @create: 2021-12-21 14:33
 */
public class Examples {
    //自定义条件搜索对象1
    public static Example createExample1(User user){
        //自定义查询条件
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();//条件构造器
        if(user != null){
            if(!StringUtils.isEmpty(user.getAccount()))
            {
                criteria.andNotEqualTo("account",user.getAccount());
            }
            if(!StringUtils.isEmpty(user.getPassword())){
                criteria.andLike("password",'%'+user.getPassword()+'%');
            }
        }
        return example;
    }//分开写便于解耦，实际上应该再建立一个新类，专用于写example条件
}
