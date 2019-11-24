package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.model.WsinforExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WsinforMapper {
    int countByExample(WsinforExample example);

    int deleteByExample(WsinforExample example);

    int deleteByPrimaryKey(String workshopid);

    int insert(Wsinfor record);

    int insertSelective(Wsinfor record);

    List<Wsinfor> selectByExample(WsinforExample example);

    List<Wsinfor> selectAll();

    Wsinfor selectByPrimaryKey(String workshopid);

    int updateByExampleSelective(@Param("record") Wsinfor record, @Param("example") WsinforExample example);

    int updateByExample(@Param("record") Wsinfor record, @Param("example") WsinforExample example);

    int updateByPrimaryKeySelective(Wsinfor record);

    int updateByPrimaryKey(Wsinfor record);

    int updateUnfixStatus(String workshopid);

    int updateFixStatus(String workshopid);
}