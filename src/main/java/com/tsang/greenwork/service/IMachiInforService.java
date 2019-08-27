package com.tsang.greenwork.service;


import com.tsang.greenwork.model.Machinfor;

import java.util.List;

public interface IMachiInforService {



    /**
     * 增加
     * @param record Machinfor对象
     * @return
     */
    int insertSelective(Machinfor record);

    /**
     * 根据id删除
     * @param machineid 设备id'
     * @return
     */
    int deleteByPrimaryKey(String machineid);

    /**
     * 更新
     * @param record Machinfor对象
     * @return
     */
    int updateByPrimaryKeySelective(Machinfor record);

    /**
     * 全查
     * @return
     */
    List<Machinfor> selectByAll();


    /**
     * 根据车间id单查
     * @param workshopid 所属生产车间id
     * @return
     */
    Machinfor selectByPrimaryKey(String workshopid);

    /**
     *
     * @param workshopid 所属生产车间id
     * @return
     */
    List<Machinfor> selectAllByWorkshopid(String workshopid);


    /**
     * 根据设备id单查
     * @param machineid 设备id'
     * @return
     */
    Machinfor selectByMachineid(String machineid);

    /**
     * 根据姓名查车间
     * @param username 负责人姓名
     * @return
     */
    Machinfor selectByUsername(String username);
}
