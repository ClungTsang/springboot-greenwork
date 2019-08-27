package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.service.IRandomNumService;
import com.tsang.greenwork.utils.RandomNumUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RandomNumServiceImpl implements IRandomNumService {
    @Override
    public StringBuilder PickMachNum() throws InterruptedException {
        return RandomNumUtil.PickMachNum();
    }

    @Override
    public StringBuilder PickWsNum() {
        return RandomNumUtil.PickWsNum();
    }
}
