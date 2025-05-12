package com.hty.demo3;

import com.hty.demo3.mapper.UserMapper;
import com.hty.demo3.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyBatisTest {


    @Test
    public void testMyBatis() throws IOException {
        //���غ��������ļ�
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //��ȡSqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder
                = new SqlSessionFactoryBuilder();
        //��ȡSqlSessionFactory
        SqlSessionFactory sqlSessionFactory
                = sqlSessionFactoryBuilder.build(is);
        //��ȡSqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);//true�����Զ��ύ
        //��ȡMapper�ӿڶ���
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //���Թ���
        int result = mapper.insertUser();
        System.out.println("result:" + result);
    }

    @Test
    public void testCRUD() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        mapper.updateUser();
//        mapper.deleteUser();
        User user = mapper.getUserById();
        System.out.println(user);
    }

    @Test
    public void JDBCTest() throws IOException, SQLException, ClassNotFoundException {
        String username = "root";
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
//        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = '" + username + "'");//ƴ���ַ���
        PreparedStatement ps = connection.prepareStatement("select * from t_user where username = ? ");//ռλ��
        ps.setString(1, username);//���ò���
    }
    @Test
    public void testgetUser() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByName("����");
        System.out.println(user);
    }
}
