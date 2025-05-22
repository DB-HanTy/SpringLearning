package com.hty.resultmap;

import com.hty.resultmap.mapper.DeptMapper;
import com.hty.resultmap.mapper.EmpMapper;
import com.hty.resultmap.pojo.Dept;
import com.hty.resultmap.pojo.Emp;
import com.hty.resultmap.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class RestMapTest {
//    @Test
//    public  void  testGetAllEmp() throws IOException {
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        List<Emp> list = mapper.getAllEmp();
//        list.forEach(emp -> System.out.println(emp));
//
//    }
//    @Test
//    public  void  testGetAndDept() throws IOException {
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        Emp emp = mapper.getEmpAndDept(1);
//        System.out.println(emp);
//    }
    @Test
    public  void  testGetAndEmp() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

}
