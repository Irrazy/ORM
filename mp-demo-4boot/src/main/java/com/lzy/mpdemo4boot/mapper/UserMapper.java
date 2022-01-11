package com.lzy.mpdemo4boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.mpdemo4boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
