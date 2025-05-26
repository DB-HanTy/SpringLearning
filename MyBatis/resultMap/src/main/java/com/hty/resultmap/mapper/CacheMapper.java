package com.hty.resultmap.mapper;

import com.hty.resultmap.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

}
