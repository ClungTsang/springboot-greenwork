package com.tsang.greenwork.mapper;

import com.tsang.greenwork.model.Envequip;
import com.tsang.greenwork.model.EnvequipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnvequipMapper {
    int countByExample(EnvequipExample example);

    int deleteByExample(EnvequipExample example);

    int deleteByPrimaryKey(String workshopid);

    int insert(Envequip record);

    int insertSelective(Envequip record);

    List<Envequip> selectByExample(EnvequipExample example);

    Envequip selectByPrimaryKey(String workshopid);

    int updateByExampleSelective(@Param("record") Envequip record, @Param("example") EnvequipExample example);

    int updateByExample(@Param("record") Envequip record, @Param("example") EnvequipExample example);

    int updateByPrimaryKeySelective(Envequip record);

    int updateByPrimaryKey(Envequip record);
}