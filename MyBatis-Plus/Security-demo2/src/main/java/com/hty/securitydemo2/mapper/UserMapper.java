package com.hty.securitydemo2.mapper;

import com.hty.securitydemo2.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 33038
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-07-26 22:34:40
* @Entity com.hty.securitydemo2.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




