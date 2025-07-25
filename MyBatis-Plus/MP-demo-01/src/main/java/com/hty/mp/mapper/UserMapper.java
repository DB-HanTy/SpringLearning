package com.hty.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hty.mp.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    Page<User> selectPageVo(@Param("age") Page<User> page,@Param("age") Integer age);

}
