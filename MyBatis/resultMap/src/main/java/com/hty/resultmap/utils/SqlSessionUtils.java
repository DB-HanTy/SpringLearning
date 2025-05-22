package com.hty.resultmap.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    public static SqlSession getSqlSession() throws IOException {
        SqlSession sqlSession = null;
        InputStream is = SqlSessionUtils.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}
