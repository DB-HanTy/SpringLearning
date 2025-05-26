package com.hty.mybatis_mbg;

import com.hty.mybatis_mbg.mapper.EmpMapper;
import com.hty.mybatis_mbg.pojo.Emp;
import com.hty.mybatis_mbg.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MBGTest {
    @Test
    public void test() throws Exception {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));
    }
}
