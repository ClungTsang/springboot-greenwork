package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Elefee;
import com.tsang.greenwork.model.ElefeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ElefeeMapper {
    int countByExample(ElefeeExample example);

    int deleteByExample(ElefeeExample example);

    int deleteByPrimaryKey(String rangee);

    int insert(Elefee record);

    int insertSelective(Elefee record);

    List<Elefee> selectByExample(ElefeeExample example);

    List<Elefee> selectAll();

    Elefee selectByPrimaryKey(String rangee);

    int updateByExampleSelective(@Param("record") Elefee record, @Param("example") ElefeeExample example);

    int updateByExample(@Param("record") Elefee record, @Param("example") ElefeeExample example);

    int updateByPrimaryKeySelective(Elefee record);

    int updateByPrimaryKey(Elefee record);
}