package com.tsang.greenwork.service;


import com.tsang.greenwork.model.Standard;

import java.util.List;

public interface IStandardService {

    /**
     *
     * @param record Standard对象
     * @return
     */
    int update(Standard record);

    /**
     *
     * @param name 姓名
     * @return Standard对象
     */
    Standard selectById(String name );

    /**
     *
     * @return Standard数组
     */
    List<Standard> selectByAll();

}
