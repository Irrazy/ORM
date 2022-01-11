package com.lzy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: jdbc-template-demo
 * @description: book
 * @author: 作者
 * @create: 2021-12-24 10:42
 */
@Data
@Table(name="book")
public class Book {

    //不要纠结用JdbcTemplate连接pgsql时，id无法默认自增，所以执行sql语句写具体，sql语句中去掉id这个字段，会在数据库中自增的（数据库表设置即可）
    //@GeneratedValue(strategy = GenerationType.AUTO,generator = "JDBC")
    @Id
    Long bid;
    @Column
    String bname;
    @Column
    Long bcount;
    @Column
    String bauthor;
}
