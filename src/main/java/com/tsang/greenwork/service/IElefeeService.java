package com.tsang.greenwork.service;

import com.tsang.greenwork.model.Elefee;

import java.util.List;

public interface IElefeeService {


    /**
     * 增加新的峰值电费价格表
     * @param record
     * @return
     */
    int insertElefee(Elefee record);

    /**
     * 根据峰值删除
     * @param range
     * @return
     */
    int deleteEleffByRange(String range);

    /**
     * 更新电费价格表
     * @param record
     * @return
     */
    int updateElefee(Elefee record);

    /**
     * 根据峰值差
     * @param range
     * @return
     */
    Elefee selectByRange(String range);

    /**
     * 全查
     * @return
     */
    List<Elefee> selectAll();
}
