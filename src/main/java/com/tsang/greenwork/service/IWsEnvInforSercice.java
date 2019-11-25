package com.tsang.greenwork.service;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.model.Wsenvinfor;

import java.util.List;
import java.util.Map;

public interface IWsEnvInforSercice {

    /**
     * 增加
     * @param record  Wsenvinfor对象
     * @return
     */
    int insertSelective(Wsenvinfor record);

    /**
     * 全查
     * @return Wsenvinfor对象
     */
    List<Wsenvinfor> selectByAll();

    /**
     * 根据车间id单查所有运行情况
     * @return Wsenvinfor对象
     */
    List<Wsenvinfor> selectByPrimaryId(String workshopid);

    /**
     * 查询所有车间的最新环境数据
     * @return Wsenvinfor对象
     */
    List<Wsenvinfor> selectCurrentData();


    /**
     * 获取当日的所有数据
     * @return
     */
    JSONObject selectAllAvgDataWithDayByWorkshopid(String workshopid);

    /**
     * 获取当周的所有数据
     * @return
     */
    Map selectAllAvgDataWithWeekByWorkshopid(String workshopid);

    /**
     * 获取当月的所有数据
     * @return
     */
    Map selectAllAvgDataWithMonthByWorkshopid(String workshopid);

    /**
     * 获取可查询的设备
     * @param workshopid
     * @return
     */
    Map ableSelectByWorkshopid(String workshopid);

    /**
     * 查询车间指定日期
     * @param workshopid
     * @param targetDate
     * @return
     */
    List selectByWorkshopidWithDate(String workshopid, String targetDate);


    /**
     * 根据车间查询最新数据
     * @return Wsenvinfor对象
     */
    Wsenvinfor selectCurrentDataByWorkshopid(String workshopid);

//    List<Wsenvinfor> ableSelectByWorkshopid(String workshopid);
}



