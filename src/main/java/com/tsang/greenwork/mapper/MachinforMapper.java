package com.tsang.greenwork.mapper;

import java.util.List;

import com.tsang.greenwork.model.Machinfor;
import com.tsang.greenwork.model.MachinforExample;
import org.apache.ibatis.annotations.Param;

public interface MachinforMapper {
    int countByExample(MachinforExample example);

    int deleteByExample(MachinforExample example);

    int deleteByPrimaryKey(String machineid);

    int insert(Machinfor record);

    int insertSelective(Machinfor record);

    List<Machinfor> selectByExample(MachinforExample example);

    Machinfor selectByPrimaryKey(String machineid);

    int updateByExampleSelective(@Param("record") Machinfor record, @Param("example") MachinforExample example);

    int updateByExample(@Param("record") Machinfor record, @Param("example") MachinforExample example);

    int updateByPrimaryKeySelective(Machinfor record);

    int updateByPrimaryKey(Machinfor record);

    List<Machinfor> selectAllByWorkshopid(String workshopid);

    Machinfor selectByUsername(String leader);
}