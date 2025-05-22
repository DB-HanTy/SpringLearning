package com.hty.resultmap.mapper;

import com.hty.resultmap.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    List<Emp> getEmpListByCondition(Emp emp);

    List<Emp> getEmpListByChoose(Emp emp);

    int deleteMoreByArray(@Param("eids") int[] eids);

    int insertMoreByList(@Param("emps") List<Emp> emps);

}
