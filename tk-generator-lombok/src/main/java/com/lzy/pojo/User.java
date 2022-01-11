package com.lzy.pojo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 * user1
 * @author lianzhengying
 * @date 2021-12-23 11:08:22
 */
@Table(name = "user1")
@Data
public class User implements Serializable {
    /**
     */
    @Id
    private Long id;

    /**
     */
    private String account;

    /**
     */
    private String password;

    private static final long serialVersionUID = 1L;
}