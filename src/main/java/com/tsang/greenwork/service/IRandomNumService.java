package com.tsang.greenwork.service;

import java.util.Map;

public interface IRandomNumService {

    /**
     *
     * @return
     * @throws InterruptedException
     */
    StringBuilder  PickMachNum() throws InterruptedException;

    /**
     * @return
     */
    StringBuilder  PickWsNum();
}
