package com.lzy.mpdemo4boot.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: mp-demo-4boot
 * @description: user
 * @author: 作者
 * @create: 2021-12-14 17:38
 */


@Data
//@Data是Lombok插件的注解 自动生成getter/setter方法 无参构造方法 equals与hashcode方法
//@Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@TableName("user1")
public class User {
    //type = IdType.AUTO,数据库ID自增
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    @TableField(value="account")
    private String account;
    @TableField(value="password")
    private String password;

    //自己编写一个两个参数的构造方法，为后面的插入数据做准备
    //id不当做参数，因为在pgsql表中设置自增

    public User(Integer id,String account,String password){
        this.id=id;
        this.account=account;
        this.password=password;
    }

    //因为自己编写了构造方法，所以会覆盖掉Lombok插件自动创建的无参构造方法
    //因此需要自己再编写一个无参的构造方法
    public User(){}




}
