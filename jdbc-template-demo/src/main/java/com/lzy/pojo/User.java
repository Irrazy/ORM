package com.lzy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: jdbc-template-demo
 * @description: user
 * @author: 作者
 * @create: 2021-12-23 17:01
 */
@Data
@Table(name="user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    Long id;
    @Column
    String account;
    @Column
    String password;

}
