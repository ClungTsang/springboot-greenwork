package com.tsang.greenwork.service;

import com.tsang.greenwork.common.ServerResponse;

public interface INumToTcpNumService {
    /**
     *
     * @param tcpNum
     * @return
     */
    ServerResponse WsInsert1(String tcpNum);

    void TranslateDtuData(String tcpNum);


}
