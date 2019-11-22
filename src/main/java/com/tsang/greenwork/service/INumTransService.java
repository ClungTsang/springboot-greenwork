package com.tsang.greenwork.service;

import java.util.Map;

public interface INumTransService {
    /**
     *
     * @param tcpNum 传入数据
     * @return 翻译后的结果
     */
    Map simulationTranslate(String tcpNum);

    Map dtuDataTranslate(String tcpNum);
}
