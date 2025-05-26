package com.hty.resultmap;

import com.hty.resultmap.mapper.CacheMapper;
import com.hty.resultmap.pojo.Emp;
import com.hty.resultmap.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    @Test
    public void testCacheOne() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpByEid(1);
        System.out.println(emp);
    }
    @Test
    public void testCacheTwo() throws IOException {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSeesion1 = sqlSessionFactory.openSession(true);
            SqlSession sqlSeesion2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSeesion1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSeesion1.close();
            CacheMapper mapper2 = sqlSeesion2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSeesion2.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
