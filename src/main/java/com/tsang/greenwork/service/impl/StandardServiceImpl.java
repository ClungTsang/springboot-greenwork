package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.StandardMapper;
import com.tsang.greenwork.model.Standard;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardServiceImpl  implements IStandardService {

    @Autowired
    private ILogService iLogService;
    @Autowired
    private StandardMapper standardMapper;

    @Override
    public Standard selectById(String name) {
        return standardMapper.selectByPrimaryKey(name);
    }

    @Override
    public List<Standard> selectByAll() {
        return standardMapper.selectByAll();
    }

    @Override
    public int update(Standard record) {
        return standardMapper.updateByPrimaryKeySelective(record);
    }
}
