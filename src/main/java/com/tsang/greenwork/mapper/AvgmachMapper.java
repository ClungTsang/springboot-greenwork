package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Avgmach;
import com.tsang.greenwork.model.AvgmachExample;
import java.util.List;

import com.tsang.greenwork.model.Machruntime;
import org.apache.ibatis.annotations.Param;

public interface AvgmachMapper {
    int countByExample(AvgmachExample example);

    int deleteByExample(AvgmachExample example);

    int insert(Avgmach record);

    int insertSelective(Avgmach record);

    List<Avgmach> selectByExample(AvgmachExample example);

    List<Avgmach> selectAllAvgDataWithDayByMachineid(String machineid);

    int updateByExampleSelective(@Param("record") Avgmach record, @Param("example") AvgmachExample example);

    int updateByExample(@Param("record") Avgmach record, @Param("example") AvgmachExample example);
}