package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Standard;
import com.tsang.greenwork.model.StandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
    int countByExample(StandardExample example);

    int deleteByExample(StandardExample example);

    int deleteByPrimaryKey(String name);

    int insert(Standard record);

    int insertSelective(Standard record);

    List<Standard> selectByExample(StandardExample example);

    List<Standard> selectByAll();

    Standard selectByPrimaryKey(String name);

    int updateByExampleSelective(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByExample(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}