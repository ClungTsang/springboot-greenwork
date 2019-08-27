package com.tsang.greenwork.service;


public interface ILogService {

    /**
     * 创建
     * @param
     * @return
     */
    int insertSelectiveNoTelephone(String Operater, String Content);


    /**
     * 创建
     * @param Operater 当前操作者
     * @param telephone 电话号码 可空
     * @param content 内容
     * @return
     */
    int insertSelective(String Operater, String telephone, String content);


    int selectCheckin(String telephone);
}
