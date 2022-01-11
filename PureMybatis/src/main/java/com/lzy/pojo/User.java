package com.lzy.pojo;

import lombok.Data;

/**
 * @program: PureMybatis
 * @description: user
 * @author: 作者
 * @create: 2021-12-13 17:12
 */

//@Data是Lombok插件的注解 自动生成getter/setter方法 无参构造方法 equals与hashcode方法
//@Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor
@Data
public class User {
    private int id;
    private String account;
    private String password;

    //自己编写一个两个参数的构造方法，为后面的插入数据做准备
    //id不当做参数，因为在pgsql表中设置自增
    public User(String account,String password){
        this.account=account;
        this.password=password;
    }

    //因为自己编写了构造方法，所以会覆盖掉Lombok插件自动创建的无参构造方法
    //因此需要自己再编写一个无参的构造方法
    public User(){}

}
