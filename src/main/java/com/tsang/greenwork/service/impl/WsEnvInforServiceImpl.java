package com.tsang.greenwork.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.mapper.AvgwsMapper;
import com.tsang.greenwork.mapper.WsenvinforMapper;
import com.tsang.greenwork.model.Avgws;
import com.tsang.greenwork.model.Avgwss;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.model.WsenvinforExample;
import com.tsang.greenwork.service.IWsEnvInforSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@CacheConfig(cacheNames = {"wsEnvInfor"})
public class WsEnvInforServiceImpl implements IWsEnvInforSercice {

    @Autowired
    private WsenvinforMapper wsenvinforMapper;
    @Autowired
    private AvgwsMapper avgwsMapper;

    /**
     * 插入环境数据
     * @param record
     * @return
     */
    @Override
    @Cacheable
    public int insertSelective(Wsenvinfor record) {
        return wsenvinforMapper.insertSelective(record);
    }

    /**
     * 获取全部环境数据
     * @return
     */
    @Override
    @Cacheable
    public List<Wsenvinfor> selectByAll() {
        return wsenvinforMapper.selectByExample(new WsenvinforExample());
    }

    @Override
    @Cacheable
    public List<Wsenvinfor> selectByPrimaryId(String workshopid) {
        WsenvinforExample wsinforExample = new WsenvinforExample();
        WsenvinforExample.Criteria criteria = wsinforExample.createCriteria();
        criteria.andWorkshopidEqualTo(workshopid);
        return wsenvinforMapper.selectByExample(wsinforExample);
    }


    @Override
    public List<Wsenvinfor> selectCurrentData() {
        List<Wsenvinfor> wsenvinfors1 = wsenvinforMapper.selectCurrentData1();
        List<Wsenvinfor> wsenvinfors2 = wsenvinforMapper.selectCurrentData2();
        List<Wsenvinfor> wsenvinfors = new ArrayList<>();
        if(!wsenvinfors1.isEmpty()){
            wsenvinfors.addAll(wsenvinfors1);
        }
        wsenvinfors.addAll(wsenvinfors2);
        return wsenvinfors;
    }


    @Override
    public Wsenvinfor selectCurrentDataByWorkshopid(String workshopid) {
        return wsenvinforMapper.selectCurrentDataByWorkshopid(workshopid);
    }

    /**
     * 获取当日所有数据的能耗平均值
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithDayByWorkshopid(String workshopid) {
        List<Avgwss> avgwss = avgwsMapper.selectAllAvgDataWithDayByWorkshopid(workshopid);
//        System.out.println(avgwss);
        //现在时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDate = dateFormat.format(date);
        String year = newDate.substring(0,4);
        String month = newDate.substring(5,7);
        String day = newDate.substring(8,10);


        JSONObject json = new JSONObject();
        for(Avgwss avgws : avgwss){
            Map map = new HashMap();

            String month1 = null;
            String day1 = null;
            String hour1 = null;

            String year1 =avgws.getYear1();


            month1 = avgws.getMonth1();
            if(avgws.getMonth1().length() ==1){
                month1 = "0"+avgws.getMonth1();
            }

            day1 = avgws.getDay1();
            if(avgws.getDay1().length() ==1){
                day1 = "0"+avgws.getDay1();
            }

            hour1 = avgws.getHour1();
            if(avgws.getHour1().length() ==1){
                hour1 = "0"+avgws.getHour1();
            }
            System.out.println(hour1);
            if(year.equals(year1) && month.equals(month1) && day.equals(day1)){
                String avg_temp = avgws.getAvgtemp();
                String avg_hum = avgws.getAvghum();
                String avg_light = avgws.getAvglight();
                String avg_pm1_0 = avgws.getAvgpm1();
                String avg_pm2_5 = avgws.getAvgpm25();
                String avg_pm10 = avgws.getAvgpm10();
                map.put("日期",year1+"-"+month1+"-"+day1+" "+hour1);
                map.put("平均PM1.0",avg_pm1_0);
                map.put("平均PM2.5",avg_pm2_5);
                map.put("平均PM10",avg_pm10);
                map.put("平均光照",avg_light);
                map.put("平均温度",avg_temp);
                map.put("平均湿度",avg_hum);
                json.put(year1+month1+day1+hour1,map);
            }
        }
//        System.out.println(json);
        return json;
    }

    /**
     * 获取当周所有数据
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithWeekByWorkshopid(String workshopid) {
        //获取当周所有数据
        List<Wsenvinfor> avgwss = wsenvinforMapper.selectAllAvgDataWithWeekByWorkshopid(workshopid);
        return getAllAvgData(avgwss);
    }


    /**
     * 获取当月所有数据
     * @return
     */
    @Override
    public JSONObject selectAllAvgDataWithMonthByWorkshopid(String workshopid) {
        //获取当周状态打开的所有数据
        List<Wsenvinfor> avgwss = wsenvinforMapper.selectAllAvgDataWithMonthByWorkshopid(workshopid);
        return getAllAvgData(avgwss);
    }

    public JSONObject getAllAvgData(List<Wsenvinfor> avgwss){
        Iterator iterator = avgwss.iterator();
        MultiValueMap<String, Wsenvinfor> stringMultiValueMap = new LinkedMultiValueMap<>();
        while(iterator.hasNext()){
            Wsenvinfor wsenvinfor = (Wsenvinfor)iterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDate = sdf.format(wsenvinfor.getUpdated());
            //获取这一周中的天
            String day1 = newDate.substring(8,10);
            //并且进行分开打包 将当日所有的能耗放在集合map中 一键多值
            stringMultiValueMap.add(day1,wsenvinfor);
        }
        //对同一天的所有数据进行求平均数
        Set<String> key = stringMultiValueMap.keySet();
        Map map =new HashMap();
        JSONObject json = new JSONObject();
        for(String day : key){
            List<Wsenvinfor> wsenvinforData = stringMultiValueMap.get(day);
            double num1 = 0;
            double num25 = 0;
            double num10 = 0;
            double num2 = 0;
            double num3 = 0;
            double num4 = 0;

            for(Wsenvinfor data : wsenvinforData){
                num1 += Double.parseDouble(data.getPm1());
                num25 += Double.parseDouble(data.getPm25());
                num10 += Double.parseDouble(data.getPm10());
                num2 += Double.parseDouble(data.getTemperature());
                num3 += Double.parseDouble(data.getHumidity());
                num4 += Double.parseDouble(data.getLight());
            }
            double avgPm1 = num1/wsenvinforData.size();
            double avgPm25 = num1/wsenvinforData.size();
            double avgPm10 = num1/wsenvinforData.size();
            double avgTemp = num2/wsenvinforData.size();
            double avgHum = num3/wsenvinforData.size();
            double getLight = num4/wsenvinforData.size();
            map.put("日",day);
            map.put("平均PM1",avgPm1);
            map.put("平均PM2.5",avgPm25);
            map.put("平均PM10",avgPm10);
            map.put("平均温度",avgTemp);
            map.put("平均湿度",avgHum);
            map.put("平均光照",getLight);
            json.put(day,map);
        }
        return json;
    }

    @Override
    public Map ableSelectByWorkshopid(String workshopid) {
        List list = wsenvinforMapper.pageByWorkshopid(workshopid);
        Iterator iterator = list.iterator();
        MultiValueMap<String,Long> map = new LinkedMultiValueMap();
        while(iterator.hasNext()){
            Wsenvinfor next = (Wsenvinfor) iterator.next();
            map.add(workshopid,next.getTime());
        }
        return map;
    }

    @Override
    public List selectByWorkshopidWithDate(String workshopid, String targetDate) {
        List<Wsenvinfor> wsenvinfors = wsenvinforMapper.selectByWorkshopid(workshopid);
        List<Wsenvinfor> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Iterator iterator = wsenvinfors.iterator();
        while(iterator.hasNext()){
            Wsenvinfor wsenvinfor= (Wsenvinfor) iterator.next();
            String date = sdf.format(wsenvinfor.getUpdated());
            if(targetDate.equals(date)){
                list.add(wsenvinfor);
            }
        }
        return averageAssign(list,10);
    }


    /**
     * list集合分页
     * @param list
     * @return
     */
    public static <T> List<List<T>> averageAssign(List<T> list,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=list.size()%n;  //(先计算出余数)
        int number=list.size()/n;  //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=list.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=list.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }
}
