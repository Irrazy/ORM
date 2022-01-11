package com.lzy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzy
 * @since 2021-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品主键
     */
    //修改主键策略
    //@TableId(value = "pid", type = IdType.AUTO)----数值/string类型
    //@TableId(value = "pid", type = IdType.ASSIGN_ID)----雪花算法字符串型
    @TableId(value = "pid", type = IdType.ASSIGN_UUID)
    private String pid;

    /**
     * 商品名称
     */
    private String pname;


}
