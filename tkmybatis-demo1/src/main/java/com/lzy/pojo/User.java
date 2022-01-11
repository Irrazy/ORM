package com.lzy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: tkmybatis-demo1
 * @description: user
 * @author: 作者
 * @create: 2021-12-20 10:44
 */
@Data
@Table(name="user1")
public class User {
    // @Id表示该字段对应数据库表的主键id
    // @GeneratedValue中strategy表示主键生成策略,有四种类型，AUTO为自动选择
    // @GeneratedValue中strategy：AUTO/Identity的generator配置为"JDBC",在数据插入完毕之后,会自动将主键id填充到实体类中.类似普通mapper.xml中配置的selectKey标签

    /**
     * 主键
     * GeneratedValue
     *      strategy: 主键生成策略 这里使用序列;--因为数据库中自增也使用的序列
     *      generator: 对应SequenceGenerator中的name属性,可自定义两者一直即可;
     * SequenceGenerator
     *      name: 对应GeneratedValue中的generator的属性,可自定义两者一直即可;
     *      sequenceName: 生成id的序列, 注意这里需要用单引号引着;
     *      allocationSize: 步增大小
     */
    //strategy: 主键生成策略 这里使用序列;--因为数据库中自增也使用的序列

    //@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq1")  //主键自增策略
    //@SequenceGenerator(name="seq1",sequenceName ="user_id_seq",allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")


    /**
     * 当pgsql中的主键id采用创建序列的方法自增时：
     1.在tk-mybatis中的pojo类中id属性的注解只用加@Id,其他任何主键策略注解都不要加
     2.在调用增加实体类方法时，最好调用userMapper.insertSelective(user)方法，会忽略掉未赋值的id值，通过数据库自增序列自增
     如果上述任何一项不遵守，都会报错---错误: null value in column "id" of relation "user1" violates not-null constraint，因为表中id字段设置为非空主键，
     而insert方法会给所有字段添加值，没有赋值的添加null
     */

    @Id
    private Long id;
    @Column
    private String account;
    @Column
    private String password;

}
