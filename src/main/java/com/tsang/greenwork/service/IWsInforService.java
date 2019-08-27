package com.tsang.greenwork.service;

import com.tsang.greenwork.model.Wsinfor;

import java.util.List;

public interface IWsInforService {

    /**
     * 增加车间编号
     * @param record
     * @return
     */
    int insertSelective(Wsinfor record);

    /**
     * 删除车间
     * @param workshopid
     * @return
     */
    int deleteByWorkshopId(String workshopid);

    /**
     *
     * @param record
     * @return
     */
    int update(Wsinfor record);

    /**
     * 根据workshopid来查询
     * @param workshopid
     * @return
     */
    Wsinfor selectByPrimaryKey(String workshopid);

    /**
     * 单查
     * @param workshopid
     * @return
     */
     List<Wsinfor> selectByExample(String workshopid);

    /**
     * 查询所有生产车间ID号
     * @return
     */
    List<Wsinfor> selectAll();

    /**
     * 修复车间状态
     * @param workshopid
     * @return
     */
    int updateFixStatus(String workshopid);

    /**
     * 格式化车间修复状态
     */
    void updateUnfixStatus();

}
