package com.lzy.incrementer;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: mp-auto-id-demo
 * @description: IdGenerator
 * @author: 作者
 * @create: 2021-12-17 16:14
 */
public class ProductIdGenerator implements IdentifierGenerator {
    private final AtomicLong al = new AtomicLong(1);

//****************************************************其实可以不写这个类，不用重写，只在pojo类id类型指定主键生成策略就好

    //重写方法1：nextId（）
    /*
    *主键生成策略：ASSIGN_ID
    *主键类型：Long,Integer,String---要跟数据库表中的id类型匹配
    *说明：支持自动转换为String类型，但数值类型不支持自动转换，需精准匹配，例如返回Long，实体主键就不支持定义为Integer
     */
    @Override
    public Long nextId(Object entity) {
        //可以将当前传入的class全类名来作为bizKey或者提取参数来生成bizKey进行分布式Id调用生成
        String bizKey = entity.getClass().getName();
        System.out.println("bizKey:" + bizKey);
        MetaObject metaObject = SystemMetaObject.forObject(entity);
        String name = (String) metaObject.getValue("pname");
        final long id = al.getAndAdd(1);
        System.out.println("为" + name + "生成主键值->:" + id);
        return id;
    }





}

