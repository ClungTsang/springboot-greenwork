package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.LogMapper;
import com.tsang.greenwork.mapper.UserMapper;
import com.tsang.greenwork.model.Log;
import com.tsang.greenwork.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogMapper logMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param Operater 操作对象
     * @param Content 信息
     * @return
     */
    @Override
    /**
     * 插入log日志 不用插入电话
     */
    public int insertSelectiveNoTelephone(String Operater, String Content) {
        Log log = new Log();
        log.setOperater(Operater);
        log.setContent(Content);
        return logMapper.insertSelective(log);
    }

    /**
     *
     * @param Operater 操作对象
     * @param telephone 电话号码
     * @param content 信息
     * @return
     */
    @Override
    /**
     * 插入log日志 有电话
     */
    public int insertSelective(String Operater, String telephone, String content) {
        Log log = new Log();
        log.setOperater(Operater);
        log.setTelephone(telephone);
        log.setContent(content);
        return logMapper.insertSelective(log);
    }

    @Override
    public int selectCheckin(String telephone) {
        return logMapper.selectByCheckin(telephone);
    }


}
