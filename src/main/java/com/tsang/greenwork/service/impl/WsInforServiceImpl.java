package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.WsinforMapper;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.model.WsinforExample;
import com.tsang.greenwork.service.IWsInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Service
@CacheConfig(cacheNames = {"wsInfor"})
public class WsInforServiceImpl implements IWsInforService {
    @Autowired
    private WsinforMapper wsinforMapper;

    /**
     * 增
     * @param record
     * @return
     */
    @Override
    @Cacheable
    public int insertSelective(Wsinfor record) {
        return wsinforMapper.insertSelective(record);
    }

    /**
     * 删
     * @param workshopid
     * @return
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public int deleteByWorkshopId(String workshopid) {
        return wsinforMapper.deleteByPrimaryKey(workshopid);
    }

    /**
     *
     * @param record
     * @return
     */
    @Override
    @CachePut
    public int update(Wsinfor record) {
        return wsinforMapper.updateByPrimaryKeySelective(record);
    }



    /**
     * 全查
     * @return
     */
    @Override
    @Cacheable
    public List<Wsinfor> selectAll() {
        return  wsinforMapper.selectAll();
    }


    /**
     * 单查
     * @param workshopid
     * @return
     */
    @Override
    @Cacheable
    public Wsinfor selectByPrimaryKey(String workshopid) {
        return wsinforMapper.selectByPrimaryKey(workshopid);
    }

    @Override
    @Cacheable
    public List<Wsinfor> selectByExample(String workshopid){

        WsinforExample wsinforExample = new WsinforExample();
        WsinforExample.Criteria criteria = wsinforExample.createCriteria();
        criteria.andWorkshopidEqualTo(workshopid);
        return wsinforMapper.selectByExample(wsinforExample);
    }


    /**
     * 格式化车间修复状态
     */
    @Override
    public void updateUnfixStatus() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(year, month, day, 00, 00, 00);//设置要执行的日期时间

        Date defaultdate = calendar.getTime();

        Timer dTimer = new Timer();
        dTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                List<Wsinfor> wsinfors = wsinforMapper.selectAll();
                for (Wsinfor wsinfor:wsinfors) {
                    wsinforMapper.updateUnfixStatus(wsinfor.getWorkshopid());
                }
            }
        }, defaultdate , 24* 60* 60 * 1000);
    }

    @Override
    @CachePut
    public int updateFixStatus(String workshopid) {
        return wsinforMapper.updateUnfixStatus(workshopid);
    }
}
