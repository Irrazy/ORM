package com.lzy.mapper;

import com.lzy.pojo.User;
import com.lzy.common.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Mapper
public interface UserMapper extends BaseMapper<User>, MySqlMapper {
}
