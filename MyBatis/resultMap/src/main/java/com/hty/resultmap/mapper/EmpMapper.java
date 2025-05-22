package com.hty.resultmap.mapper;

import com.hty.resultmap.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询员工信息
     */
    List<Emp> getAllEmp();

    Emp getEmpAndDept(@Param("eid") Integer eid);

    Emp getEmpAndDeptStepOne(@Param("eid") Integer eid);

    List<Emp> getEmpListByDid(@Param("did") int did);
}
