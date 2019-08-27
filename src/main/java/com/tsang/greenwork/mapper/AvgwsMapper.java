package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Avgws;
import com.tsang.greenwork.model.AvgwsExample;
import java.util.List;
import java.util.Map;

import com.tsang.greenwork.model.Machruntime;
import org.apache.ibatis.annotations.Param;

public interface AvgwsMapper {
    int countByExample(AvgwsExample example);

    int deleteByExample(AvgwsExample example);

    int insert(Avgws record);

    int insertSelective(Avgws record);

    List<Avgws> selectByExample(AvgwsExample example);

    int updateByExampleSelective(@Param("record") Avgws record, @Param("example") AvgwsExample example);

    int updateByExample(@Param("record") Avgws record, @Param("example") AvgwsExample example);

    List<Avgws> selectAllAvgDataWithDayByWorkshopid(String workshopid);
}