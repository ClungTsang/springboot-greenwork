package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.EnvequipMapper;
import com.tsang.greenwork.model.Envequip;
import com.tsang.greenwork.model.EnvequipExample;
import com.tsang.greenwork.service.IEnvEquipService;
import com.tsang.greenwork.service.IInsertDBService;
import com.tsang.greenwork.utils.CrcUtil;
import com.tsang.greenwork.utils.HEXUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
@CacheConfig(cacheNames = {"envEquip"})
public class EnvEquipImpl implements IEnvEquipService {

    @Autowired
    private EnvequipMapper envequipMapper;
    @Autowired
    private IInsertDBService iNumToTcpNumService;
    /**
     * 新增数据
     * @param record
     * @return
     */
    @Override
    @Cacheable
    public int insertSelective(Envequip record) {
        return envequipMapper.insertSelective(record);
    }

    /**
     * 删除
     * @param envequipid 监控设备id
     * @return
     */
    @Override
    @CacheEvict(beforeInvocation = true)
    public int deleteByPrimaryKey(String envequipid) {
        return envequipMapper.deleteByPrimaryKey(envequipid);
    }

    /**
     * 全查
     * @return
     */
    @Override
    @Cacheable
    public List<Envequip> selectByAll() {
        return envequipMapper.selectByExample(new EnvequipExample());
    }


    /**
     * 根据生产车间id
     * @param workshopid 车间id
     * @return
     */
    @Override
    @Cacheable
    public Envequip selectByPrimaryKey(String workshopid) {
        return envequipMapper.selectByPrimaryKey(workshopid);
    }

    /**
     * 更新操作
     * @param record Envequip对象
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Envequip record) {
        return envequipMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 0为crc正确 且自动关闭警告设备
     * 1为crc正确 且自动打开警告设备
     * 2为crc正确
     * 3为crc不正确
     *
     * @param object
     * @return
     */
    @Override
    public int dtuTranslate(Object object) {
        CrcUtil crcUtil = new CrcUtil();
        String dtuData = String.valueOf(object);
        String head = dtuData.substring(0,6);
        String body =null;
        String crcNum = null;
        if(head.equals("110302")) {
            body =dtuData.substring(0,10);
            crcNum = dtuData.substring(10,14);
            String crc3 = crcUtil.getCRC3(HEXUtils.hexStringToByte(body));
            if(crc3.equals(crcNum)){
                String pm = dtuData.substring(6,10);
                String s = new BigInteger(pm, 16).toString();
                if (Integer.valueOf(s) > 1000) {
                    return 1;
                } else {
                    return 0;
                }
            }else{
                return 3;
            }
        }
        else if(head.equals("110328")){
            body = dtuData.substring(0,86);
            crcNum = dtuData.substring(86,90);
            String crc3 = crcUtil.getCRC3(HEXUtils.hexStringToByte(body));
            if(crc3.equals(crcNum)){
                return 2;
            }else{
                return 3;
            }
        }
        else if(head.equals("110500")){
            body =dtuData.substring(0,12);
            crcNum = dtuData.substring(12,16);
            String crc3 = crcUtil.getCRC3(HEXUtils.hexStringToByte(body));
            if(crc3.equals(crcNum)){
                return 2;
            }else{
                return 3;
            }
        }
        else if (head.equals("010328")){
            body = dtuData.substring(0,86);
            crcNum = dtuData.substring(86,90);String crc3 = crcUtil.getCRC3(HEXUtils.hexStringToByte(body));
            if(crc3.equals(crcNum)){
                return 2;
            }else{
                return 3;
            }
        }
        else{
            return 4;
        }
    }
}

