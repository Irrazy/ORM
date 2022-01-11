package com.lzy.serviceImpl;

import com.lzy.common.Examples;
import com.lzy.mapper.UserMapper;
import com.lzy.pojo.User;
import com.lzy.service.UserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: tkmybatis-demo1
 * @description: UserServiceImpl
 * @author: 作者
 * @create: 2021-12-20 11:51
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     *
     * 当pgsql中的主键id采用创建序列的方法自增时：
     * 1.在tk-mybatis中的pojo类中id属性的注解只用加@Id,其他任何主键策略注解都不要加
     * 2.在调用增加实体类方法时，最好调用userMapper.insertSelective(user)方法，会忽略掉未赋值的id值，通过数据库自增序列自增
     * 如果上述任何一项不遵守，都会报错---错误: null value in column "id" of relation "user1" violates not-null constraint，因为表中id字段设置为非空主键
     *  @Override
     *         public int insert(User user) {
     *         //insert方法会给所有字段添加值，没有赋值的添加null
     *         return userMapper.insert(user);
     *     }
     * @return
     */

    //增加一个

      @Override
      public int insertSelective(User user) {
          //用insertSelective不会给没有赋值的字段插入null值，有些字段有默认值就要用这个方法
           return userMapper.insertSelective(user);
        }



    //删除
      //ById
    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }
      //DeleteMapper接口
    @Override
    public int deleteMapper(User user){
        //DeleteMapper接口有一个方法 delete，参数就是数据库表对应的Java实体类，
        // 参数实体中哪些字段不为null，就会被作为删除sql语句的条件字段，且条件关系是 and，而不是 or。
        //在定义实体类时，每个成员变量的类型都应该是Java类，不能是基本类型
          return userMapper.delete(user);
    }



    //更新
    //先查出来一个实体（ById）再更新
    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user); //根据主键字段准确地修改某一条记录。---update table set 所有字段
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
        //根据主键字段准确地修改某一条记录的部分字段（实体类参数的不为 null 的字段）。--update table set 部分字段
    }



//查--单查


    //查一个ById
    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    //自定义条件搜索1
    @Override
    public List<User> selectExample(User user) {
          Example example = Examples.createExample1(user);
        return userMapper.selectByExample(example);
    }

    /**其他查询相关方法
     *List<T> select(T var1); //继承SelectMapper 接口，类似delete方法
     * T selectOne(T var1); //与 select 方法一样，只是返回结果只能为空或者一个，如果有多个，则抛出异常
     *int selectCount(T var1); //查询满足条件的记录有多少条
     * boolean existsWithPrimaryKey(Object var1); //根据主键查询某条记录是否存在
     */



    //批量查询
    //查所有
    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }







}
