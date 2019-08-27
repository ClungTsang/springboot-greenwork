package com.tsang.greenwork.service;


import com.tsang.greenwork.model.Envequip;

import java.util.List;

public interface IEnvEquipService {
    /**
     * 增加
     * @param record 环境设备
     * @return  status-0成功-1失败 msg信息 data数据
     */
    int insertSelective(Envequip record);

    /**
     * 根据id删除
     * @param envequipid 环境设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    int deleteByPrimaryKey(String envequipid);

    /**
     * 全查
     * @return status-0成功-1失败 msg信息 data数据
     */
    List<Envequip> selectByAll();


    /**
     * 根据生产车间查询
     * @param workshopid
     * @return status-0成功-1失败 msg信息 data数据
     */
    Envequip selectByPrimaryKey(String workshopid);

    /**
     * 更新
     * @param record 环境设备
     * @return status-0成功-1失败 msg信息 data数据
     */
    int updateByPrimaryKeySelective(Envequip record);

    /**
     * 通过dtu返回得到的数据
     * 判断
     * @return
     */
    int dtuTranslate(Object object);
}
