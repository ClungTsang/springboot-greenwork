package com.tsang.greenwork.service;

import com.tsang.greenwork.common.ServerResponse;

public interface IInsertDBService {
    /**
     *
     * @param tcpNum
     * @return
     */
    ServerResponse simulation_InsertDB(String tcpNum);


    ServerResponse dtuDataInsertDB(String tcpNum);


}
