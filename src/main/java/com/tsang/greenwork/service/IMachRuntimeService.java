package com.tsang.greenwork.service;


import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.model.Machruntime;

import java.util.List;
import java.util.Map;

public interface IMachRuntimeService {
    /**
     * 全查
     * @return
     */
    List<Machruntime> selectByAll();

    /**
     * 根据设备id查询
     * @param machineid
     * @return
     */
    List<Machruntime> selectByPrimaryId(String machineid);

    /**
     * 根据生产id查询
     * @param workshopid
     * @return
     */
    List<Machruntime> selectByWorkshopid(String workshopid);

    /**
     * 获取最新的设备运行情况数据
     * @return
     */
    List<Machruntime> selectCurrentData();

    /**
     * 获取所选车间的所有设备的最新运行情况
     * @return
     */
    List<Machruntime> selectCurrentDataByWorkshopid(String workshopid);

    /**
     * 获取当日的所有数据
     * @return
     */
    JSONObject selectAllAvgDataWithDayByMachineid(String machineid);

    /**
     * 获取当周的所有数据
     * @return
     */
    Map selectAllAvgDataWithWeekByMachineid(String machineid);

    /**
     * 获取当月的所有数据
     * @return
     */
    Map selectAllAvgDataWithMonthByMachineid(String machineid);

    /**
     * 获取可查询的设备
     * @param machineid
     * @return
     */
//    Map pageByMachineid(String machineid);

    /**
     * 查询上一个周期的所有数据
     * @return
     */
    List<Machruntime>  selectLastData();

    /**
     * 查询最新一条数据
     * @param machineid 设备id
     * @return
     */
    Machruntime selectNewlestDataByMachineid(String machineid);


    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Machruntime record);

    /**
     *
     * @param machruntime 设备运行情况
     * @return
     */
    int insertByPrimaryKey(Machruntime machruntime);

    /**
     * 统计当月该设备的打开状态次数
     * @param machineid 设备id
     * @return
     */
    int countByMachineid(String machineid);

    /**
     * 获取可查询的设备
     * @param machineid
     * @return
     */
    Map ableSelectByMachineid(String machineid);

    /**
     * 查询车间指定日期
     * @param machineid
     * @param targetDate
     * @return
     */
    List selectByMachineidWithDate(String machineid, String targetDate);

}
