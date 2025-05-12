package com.hty.demo3.mapper;

import com.hty.demo3.pojo.User;

import java.util.List;

/**
 * mybatis���ýӿ��еķ������Զ�ƥ��sql���
 */
public interface UserMapper {
    int insertUser();
    void updateUser();
    void deleteUser();
    User getUserById();
    List<User> getAllUser();

    User getUserByName(String username);



}
