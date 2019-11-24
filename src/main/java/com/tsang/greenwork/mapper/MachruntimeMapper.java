package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.model.MachruntimeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.crypto.Mac;
import java.util.List;

public interface MachruntimeMapper {

    int countByExample(MachruntimeExample example);

    int countByMachineid(String machineid);

    List<Machruntime> selectByAll(Machruntime machruntime);

    List pageByMachineid(String machineid);

    int deleteByExample(MachruntimeExample example);

    int insert(Machruntime record);

    int insertSelective(Machruntime record);

    int updateByExampleSelective(@Param("record") Machruntime record, @Param("example") MachruntimeExample example);

    int updateByExample(@Param("record") Machruntime record, @Param("example") MachruntimeExample example);

    int updateByPrimaryKeySelective(Machruntime record);

    List<Machruntime> selectByExample(MachruntimeExample example);

    List<Machruntime> selectByPrimaryKey(String machineid);

    List<Machruntime> selectByMachineid(String machineid);

    List<Machruntime> selectCurrentData();

    List<Machruntime> selectLastData();

    Machruntime selectNewlestDataByMachineid(String machinedid);

    List<Machruntime> selectAllAvgDataWithWeekByMachineid(String machineid);

    List<Machruntime> selectAllAvgDataWithMonthByMachineid(String machineid);
}