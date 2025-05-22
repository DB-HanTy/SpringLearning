package com.hty.demo3.mapper;

import com.hty.demo3.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * mybatis调用接口中的方法，自动匹配sql语句
 */
public interface UserMapper {
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getAllUser();
    User getUserByName(String username);

    User checkLoginByParam(@Param("username") String username, @Param("password") String password);


}
