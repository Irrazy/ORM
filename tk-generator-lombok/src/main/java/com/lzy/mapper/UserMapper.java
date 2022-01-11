package com.lzy.mapper;

import com.lzy.common.BaseMapper;
import com.lzy.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lianzhengying
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}