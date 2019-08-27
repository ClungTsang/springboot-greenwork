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

    @Override
    @Cacheable(cacheNames = {"elefee"})
    /**
     * 对该方法的结果进行缓存
     */
    public Elefee selectByRange(String range) {
        return elefeeMapper.selectByPrimaryKey(range);
    }

    @Override
    public List<Elefee> selectAll() {
        return elefeeMapper.selectAll();
    }

    @Override
    @CachePut(key = "#result.rangee")
    /**
     * 既调用方法 又更新缓存数据 同时更新缓存
     * 修改了数据库的某个数据 同时更新缓存
     * 运行
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     */
    public int deleteEleffByRange(String range) {
        return elefeeMapper.deleteByPrimaryKey(range);
    }

    @Override
    @CacheEvict(beforeInvocation = true)

//     @CacheEvict:缓存清除
//       key:指定要清除的数据
//       allEntries = true : 指定清除这个缓存中的所有数据
//       beforeInvocation=fales: 缓存的清除是否在方法之前执行
//       默认代表缓存清除操作是在方法执行之后执行；如果出现异常缓存就不会清除
//      beforeInvocation=true  代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
    public int insertElefee(Elefee record) {
        return elefeeMapper.insert(record);
    }

    @Override
    public int updateElefee(Elefee record) {
        return elefeeMapper.updateByPrimaryKey(record);
    }
}
