package com.hty.resultmap;

import com.hty.resultmap.mapper.DynamicSQLMapper;
import com.hty.resultmap.pojo.Emp;
import com.hty.resultmap.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class DynamicSQLTest {
    @Test
    public void testGetEmpByCondition() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> empList = mapper.getEmpListByCondition(new Emp(null, "ÕÅÈý", 23, "ÄÐ", "123@qq.com", null));
        System.out.println(empList);
    }
}
