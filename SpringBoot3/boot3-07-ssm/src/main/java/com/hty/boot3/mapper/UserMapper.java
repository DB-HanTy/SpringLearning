package com.hty.boot3.mapper;

import com.hty.boot3.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 每个方法都在Mapper文件中有一个sql标签对应
     * 所有参数都应该用@Param进行签名，以后使用指定的名字在SQL
     * @param id
     * @return
     */
    public User getUserById(@Param("id") Integer id);
}
