package com.hty.demo3.mapper;

import com.hty.demo3.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);
    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUserList();

    int getCount();

    /**
     * 根据用户id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> getUserToMap(@Param("id") int id);

//    List<Map<String, Object>> getAllUserToMap();

    @MapKey("id")
    Map<String, Object> getAllUserToMap();

    List<User> testMohu(@Param("mohu") String mohu);

    int deleteMore(@Param("ids") String ids);

    List<User> getAllUser(@Param("tableName") String tableName);

    void insertUser(User user);
}
