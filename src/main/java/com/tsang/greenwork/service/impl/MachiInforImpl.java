package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.MachinforMapper;
import com.tsang.greenwork.model.Machinfor;
import com.tsang.greenwork.model.MachinforExample;
import com.tsang.greenwork.service.IMachiInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MachiInforImpl implements IMachiInforService {
    @Autowired
    private MachinforMapper machinforMapper;

    /**
     * 新增数据
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Machinfor record) {
        return machinforMapper.insertSelective(record);
    }

    /**
     * 删除
     * @param machineid
     * @return
     */
    @Override
    public int deleteByPrimaryKey(String machineid) {
        return machinforMapper.deleteByPrimaryKey(machineid);
    }

    /**
     * 更新操作
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Machinfor record) {
        return machinforMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 全查
     * @return
     */
    @Override
    public List<Machinfor> selectByAll() {
        return machinforMapper.selectByExample(new MachinforExample());
    }

    /**
     * 根据设备id查询
     * @param machineid
     * @return
     */
    @Override
    public Machinfor selectByMachineid(String machineid) {
        return machinforMapper.selectByPrimaryKey(machineid);
    }

    /**
     *
     * @param username 负责人姓名
     * @return
     */
    @Override
    public Machinfor selectByUsername(String username) {
        return machinforMapper.selectByUsername(username);
    }

    /**
     * 根据设备id单查
     * @param machineid
     * @return
     */
    @Override
    public Machinfor selectByPrimaryKey(String machineid) {
        return machinforMapper.selectByPrimaryKey(machineid);
    }

    /**
     * 根据车间id查询所有设备
     * @param workshopid
     * @return
     */
    @Override
    public List<Machinfor> selectAllByWorkshopid(String workshopid) {
        return machinforMapper.selectAllByWorkshopid(workshopid);
    }
}
