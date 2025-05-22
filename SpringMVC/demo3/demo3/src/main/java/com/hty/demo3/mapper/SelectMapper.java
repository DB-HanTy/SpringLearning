package com.hty.demo3.mapper;

import com.hty.demo3.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * ����id��ѯ�û���Ϣ
     */
    User getUserById(@Param("id") Integer id);
    /**
     * ��ѯ�����û���Ϣ
     * @return
     */
    List<User> getUserList();

    int getCount();

    /**
     * �����û�id��ѯ�û���ϢΪmap����
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
