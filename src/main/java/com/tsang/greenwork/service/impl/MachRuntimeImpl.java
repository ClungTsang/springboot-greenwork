package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.AvgmachMapper;
import com.tsang.greenwork.mapper.MachruntimeMapper;
import com.tsang.greenwork.model.Avgmach;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.model.MachruntimeExample;
import com.tsang.greenwork.service.IMachRuntimeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MachRuntimeImpl implements IMachRuntimeService {
    @Autowired
    private MachruntimeMapper machruntimeMapper;

    @Autowired
    private AvgmachMapper avgmachMapper;
    @Override
    public int updateByPrimaryKeySelective(Machruntime record) {
        return machruntimeMapper.updateByPrimaryKeySelective(record);
    }
    /**
     * 全查
     * @return
     */
    @Override
    public List<Machruntime> selectByAll() {
        return machruntimeMapper.selectByExample(new MachruntimeExample());
    }

    /**
     * 根据主键单查
     * @param machineid
     * @return
     */
    @Override
    public List<Machruntime> selectByPrimaryId(String machineid) {
        return machruntimeMapper.selectByMachineid(machineid);
    }

    /**
     * 根据车间id查
     * @param workshopid
     * @return
     */
    @Override
    public List<Machruntime> selectByWorkshopid(String workshopid) {
        MachruntimeExample machruntimeExample = new MachruntimeExample();
        MachruntimeExample.Criteria criteria = machruntimeExample.createCriteria();
        criteria.andWorkshopidEqualTo(workshopid);
        return machruntimeMapper.selectByExample(machruntimeExample);
    }


    @Override
    public List<Machruntime> selectCurrentData() {
        return machruntimeMapper.selectCurrentData();
    }

    @Override
    public List<Machruntime> selectCurrentDataByWorkshopid(String workshopid) {
        return null;
    }

    /**
     * 获取当日所有数据的能耗平均值
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithDayByMachineid(String machineid) {
        List<Avgmach> avgmachs = avgmachMapper.selectAllAvgDataWithDayByMachineid(machineid);
        //现在时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = dateFormat.format(date);
        String year = newDate.substring(0,4);
        String month = newDate.substring(5,7);
        String day = newDate.substring(8,10);

        Map map = new HashMap();
        JSONObject json = new JSONObject();
        for(Avgmach avgmach : avgmachs){
            String year1 =avgmach.getYear1();

            String month1 = null;
            if(avgmach.getMonth1().length() ==1){
                month1 = "0"+avgmach.getMonth1();
            }else{
                month1 = avgmach.getMonth1();
            }

            String day1 = null;
            if(avgmach.getDay1().length() ==1){
                day1 = "0"+avgmach.getDay1();
            }else{
                day1 = avgmach.getDay1();
            }

            String hour1 = null;
            if(avgmach.getHour1().length() ==1){
                hour1 = "0"+avgmach.getHour1();
            }else{
                hour1 = avgmach.getHour1();
            }
            if(year.equals(year1) && month.equals(month1) && day.equals(day1)){
                String avgNrg = avgmach.getAvgnrg();
                String avgfre = avgmach.getAvgfre();
                map.put("日期",year1+"年"+month1+"月"+day1+"日"+" "+hour1+"小时");
                map.put("平均能耗",avgNrg);
                map.put("频次",avgfre);
                json.put(year1+month1+day1+hour1,map);
            }
        }
        return json;
    }

    /**
     * 获取当周所有数据
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithWeekByMachineid(String machineid) {
        //获取当周状态打开的所有数据
        List<Machruntime> machruntimes = machruntimeMapper.selectAllAvgDataWithWeekByMachineid(machineid);
        return getAllAvgData(machruntimes);
    }


    /**
     * 获取当月所有数据
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithMonthByMachineid(String machineid) {
        //获取当周状态打开的所有数据
        List<Machruntime> machruntimes = machruntimeMapper.selectAllAvgDataWithMonthByMachineid(machineid);
        return getAllAvgData(machruntimes);
    }


    /**
     * 查询上一周期的所有数据
     * @return
     */
    @Override
    public List<Machruntime> selectLastData() {
        return machruntimeMapper.selectLastData();
    }

    @Override
    public Machruntime selectNewlestDataByMachineid(String machineid) {
        return machruntimeMapper.selectNewlestDataByMachineid(machineid);
    }

    /**
     * 插入
     * @return
     */
    @Override
    public int insertByPrimaryKey(Machruntime record) {
        return machruntimeMapper.insertSelective(record);
    }

    /**
     * 统计当月该设备的打开状态次数
     * @param machineid 设备id
     * @return
     */
    @Override
    public int countByMachineid(String machineid) {
        return machruntimeMapper.countByMachineid(machineid);
    }

    public JSONObject getAllAvgData(List<Machruntime> machruntimes){
        Iterator iterator = machruntimes.iterator();
        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();
        while(iterator.hasNext()){
            Machruntime machruntime = (Machruntime)iterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = sdf.format(machruntime.getUpdated());
            //获取这一周中的天
            String day1 = newDate.substring(8,10);
            //并且进行分开打包 将当日所有的能耗放在集合map中 一键多值
            stringMultiValueMap.add(day1,machruntime.getNrgconsumption());
        }
        //对同一天的所有数据进行求平均数
        Set<String> key = stringMultiValueMap.keySet();
        Map map =new HashMap();
        JSONObject json = new JSONObject();
        for(String day : key){
            List nums = stringMultiValueMap.get(day);
            double numm = 0;
            for(Object num : nums){
                numm += Double.parseDouble(num.toString());
            }
            //当天的平均数
            double avgNrg = numm/nums.size();
            map.put("日",day);
            map.put("平均能耗",avgNrg);
            json.put(day,map);
        }
        return json;
    }



    @Override
    public Map ableSelectByMachineid(String machineid) {
        List list = machruntimeMapper.pageByMachineid(machineid);
        Iterator iterator = list.iterator();
        MultiValueMap<String,Long> map = new LinkedMultiValueMap();
        while(iterator.hasNext()){
            Machruntime machruntime = (Machruntime) iterator.next();
            map.add(machineid,machruntime.getTime());
        }
        return map;
    }

    @Override
    public List selectByMachineidWithDate(String machineid, String targetDate) {
        List<Machruntime> machruntimes = machruntimeMapper.selectByMachineid(machineid);
        List<Machruntime> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Iterator iterator = machruntimes.iterator();
        while(iterator.hasNext()){
            Machruntime machruntime= (Machruntime) iterator.next();
            String date = sdf.format(machruntime.getUpdated());
            if(targetDate.equals(date)){
                list.add(machruntime);
            }
        }
        return WsEnvInforServiceImpl.averageAssign(list,10);
    }
}

