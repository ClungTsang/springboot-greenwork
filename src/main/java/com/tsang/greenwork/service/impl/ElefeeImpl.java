package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.ElefeeMapper;
import com.tsang.greenwork.model.Elefee;
import com.tsang.greenwork.service.IElefeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = {"elefee"})
public class ElefeeImpl implements IElefeeService {

    @Autowired
    private ElefeeMapper elefeeMapper;

    /**
     * 对该方法的结果进行 缓存
     */
    @Override
    @Cacheable
    public Elefee selectByRange(String range) {
        return elefeeMapper.selectByPrimaryKey(range);
    }

    /**
     * 对该方法的结果进行 缓存更新
     */
    @Override
    @CachePut
    public Elefee updateRangeData(String range) {
        return elefeeMapper.selectByPrimaryKey(range);
    }

    /**
     * 删除缓存，执行方法
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public Elefee deleteRangeData(String range) {
        return elefeeMapper.selectByPrimaryKey(range);
    }


    @Override
    public List<Elefee> selectAll() {
        return elefeeMapper.selectAll();
    }

    @Override
    public int deleteEleffByRange(String range) {
        return elefeeMapper.deleteByPrimaryKey(range);
    }

    @Override
    public int insertElefee(Elefee record) {
        return elefeeMapper.insert(record);
    }

    @Override
    public int updateElefee(Elefee record) {
        return elefeeMapper.updateByPrimaryKey(record);
    }
}
