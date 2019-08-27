package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.model.WsenvinforExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WsenvinforMapper {
    int countByExample(WsenvinforExample example);

    int countByWorkshopid(String machineid);

    int deleteByExample(WsenvinforExample example);

    int insert(Wsenvinfor record);

    int insertSelective(Wsenvinfor record);

    List pageByWorkshopid(String workshopid);

    List<Wsenvinfor> selectByExample(WsenvinforExample example);

    List<Wsenvinfor> selectCurrentData1();

    List<Wsenvinfor> selectCurrentData2();

    List<Wsenvinfor> selectByWorkshopid(String workshopid);

    Wsenvinfor selectCurrentDataByWorkshopid(String workshopid);

    int updateByExampleSelective(@Param("record") Wsenvinfor record, @Param("example") WsenvinforExample example);

    int updateByExample(@Param("record") Wsenvinfor record, @Param("example") WsenvinforExample example);

    List<Wsenvinfor> selectAllAvgDataWithWeekByWorkshopid(String workshopid);

    List<Wsenvinfor> selectAllAvgDataWithMonthByWorkshopid(String workshopid);
}