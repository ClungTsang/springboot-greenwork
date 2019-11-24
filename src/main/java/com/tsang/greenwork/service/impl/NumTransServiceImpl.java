package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.WsinforMapper;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.INumTransService;
import com.tsang.greenwork.utils.RandomNumUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class NumTransServiceImpl implements INumTransService {

    @Autowired
    private ILogService iLogService;
    @Autowired
    private WsinforMapper wsinforMapper;

    private static final Logger logger = LoggerFactory.getLogger(NumTransServiceImpl.class);

    @Override
    public Map dtuDataTranslate(String dtuData) {


        Map<String,Object> map = new HashMap<>();
        //根据判断前6个数字 来分析不同的接收数据
        String top6_dtuData =  dtuData.substring(0,6);
        System.out.println(dtuData);

//        System.out.println(top6_dtuData);
            if("110328".equals(top6_dtuData)){
            //注册包 返回值
            //11 03 28 77 73 30 30 31 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 3A 24
            //77 73 30 30 31代表ws001
                String register = this.hexStr2Str(dtuData,6, 16);
                return null;
            }else if("010328".equals(top6_dtuData)){
            //一个分隔用的字母
                String BFBD = "BFBD";

                Long temper = null;
                Long hum =null;
                String temperST = null;
                String humST = null;
                String lightST =null;
                String pm1ST = null;
                String pm25ST = null;
                String pm10ST  = null;

                //温湿度pm2.5 返回值
                //01 03 28 11 DF 1E 47 01 70 00 00 00 05 00 06 00 08 00 0B 00 0C 00 0A 00 0B 00 0C 00 0D 00 0E 00 0F 00 10 00 11 00 12 00 13 00 14 76 CC
                //11 DF为温度，1E 47为湿度，01 70光照，00 0B是pm2.5（00 08是pm1.0，00 0C是pm10，都有效）

                //当一切时   正常湿度数据
                temper = Long.parseLong(dtuData.substring(6, 10),16);
                hum = Long.parseLong(dtuData.substring(10,14),16);
                lightST = this.hexStr2Str(dtuData,14, 18);
                pm1ST  = this.hexStr2Str(dtuData,30,34);
                pm25ST = this.hexStr2Str(dtuData,34,38);
                pm10ST = this.hexStr2Str(dtuData,38,42);


            //当 hum 和 light 后面有 BFBD 其余后退2个字节
            if(BFBD.equals(dtuData.substring(14,18))){
                lightST = this.hexStr2Str(dtuData,18, 22);
                pm1ST  = this.hexStr2Str(dtuData,34,38);
                pm25ST = this.hexStr2Str(dtuData,38,42);
                pm10ST = this.hexStr2Str(dtuData,42,46);
            }
            //当 hum 为 BFBD 则 除了temper 全部退2个字节
            if(BFBD.equals(dtuData.substring(10,14))){

                hum = Long.parseLong(dtuData.substring(14,18),16);
                lightST = this.hexStr2Str(dtuData,18, 22);
                pm1ST  = this.hexStr2Str(dtuData,34,38);
                pm25ST = this.hexStr2Str(dtuData,38,42);
                pm10ST = this.hexStr2Str(dtuData,42,46);
                // 当 light 为 BFBD 则 除了hum 全部再往后退 2个字节
                if(BFBD.equals(dtuData.substring(18,22))){
                    lightST = this.hexStr2Str(dtuData,22, 26);
                    pm1ST  = this.hexStr2Str(dtuData,38,42);
                    pm25ST = this.hexStr2Str(dtuData,42,46);
                    pm10ST = this.hexStr2Str(dtuData,46,50);
                }
                //当light 后面为 BFBD 则 除了light 全部再往后退2个字节
                if(BFBD.equals(dtuData.substring(22,26))){
                    pm1ST  = this.hexStr2Str(dtuData,42,46);
                    pm25ST = this.hexStr2Str(dtuData,46,50);
                    pm10ST = this.hexStr2Str(dtuData,50,54);
                }

            }
            if(BFBD.equals(dtuData.substring(14,18))){
                lightST = this.hexStr2Str(dtuData,18, 22);
                pm1ST  = this.hexStr2Str(dtuData,34,38);
                pm25ST = this.hexStr2Str(dtuData,38,42);
                pm10ST = this.hexStr2Str(dtuData,42,46);
            }

            // 11 df (16进制) = (10机制) (4575-2000)/100 = 25.75 度
            // 1e 47 (16进制) = (10机制) (7807/100) = 78.07 %
            temperST = String.valueOf(
                    BigInteger.valueOf(temper)
                    .subtract(BigInteger.valueOf(2000))
                    .divide(BigInteger.valueOf(100)));
            humST = String.valueOf(
                    BigInteger.valueOf(hum).divide(BigInteger.valueOf(100)));


            System.out.println(temperST+":"+humST+":"+lightST+":"+pm1ST+":"+pm25ST+":"+pm10ST);
            Wsenvinfor wsenvinfor = new Wsenvinfor("ws001",temperST,humST,lightST,pm1ST,pm25ST,pm10ST);
            map.put("wsenvinfor",wsenvinfor);
            return map;
        }else{
            return null;
        }

    }
    public String hexStr2Str(String dtuData , int arg1 , int arg2){
        return String.valueOf(Long.parseLong(dtuData.substring(arg1, arg2),16));
    }

    @Override
    public Map<String, Object> simulationTranslate(String tcpNum) {
        Map<String, Object> map = new HashMap();
            //判断是属于什么设备
            String top5 = tcpNum.substring(0, 5);
            /**
             *ma 生产设备
             *
             * machineid（设备id） ma101：1号车间1号生产设备 ma202：2号车间2号生产设备
             * situation（状态）  1：打开 2：关闭 3：故障
             * nrgconsumption(能耗) 3:能耗3
             * frequency（频次）  1：频次1
             */
            if (tcpNum.substring(0, 2).equals("ma")) {
                String frequency = tcpNum.substring(7, 8);

                //ma 生产设备
                String situation = tcpNum.substring(5, 6);
                String nrgconsumption = tcpNum.substring(6, 7);
                if ("1".equals(situation)) {
                    //判断状态   situation    1:打开

                    Machruntime machruntime = new Machruntime(top5, situation, nrgconsumption, frequency);
                    map.put("machruntime", machruntime);
                    return map;
                } else if (situation.equals("2")) {
                    // 2：关闭c
                    String newSituation = null;
                    Random rand = new Random();
                    int i = rand.nextInt(2) + 2;
                    newSituation = String.valueOf(i);
                    Machruntime machruntime = new Machruntime(top5, newSituation, nrgconsumption, frequency);
                    map.put("machruntime", machruntime);
                    return map;
                } else {
                    return null;
                }
            } else if (tcpNum.substring(0, 2).equals("ws")) {
                /**
                 * ws 环境信息
                 * workshopid（生产车间id）  ws001 1号车间
                 * pm（pm2.5） 10：10
                 * tempperature（温度） 27：27
                 * humidity（湿度） 50:50
                 */
                Wsinfor wsinfor = wsinforMapper.selectByPrimaryKey(top5);
                String pm = null;
                String temperature = null;
                String humidity = null;
                String ele = null;
                String wsNum = null;
                String fre = null;
                String nrg = null;

                if (wsinfor.getStatuss().equals("fix")) {
                    //已经修复
                    wsNum = "" + RandomNumUtil.PickNormalWsNum(top5);
                    tcpNum = wsNum;
                }
                //未修复
                pm = tcpNum.substring(5, 7);
                temperature = tcpNum.substring(7, 9);
                humidity = tcpNum.substring(9, 11);
                ele = tcpNum.substring(11, 13);
//                fre = tcpNum.substring(14, 16);
//                nrg = tcpNum.substring(16, 18);
                int signall = 0;
                if (!pm.equals("00")) {
                    signall++;
                }
                if (!temperature.equals("00")) {
                    signall++;
                }
                if (!humidity.equals("00")) {
                    signall++;
                }
                if (!ele.equals("00")) {
                    signall++;
                }
//                Wsenvinfor wsenvinfor = new Wsenvinfor(top5, pm, temperature, humidity, ele, String.valueOf(signall));
//                map.put("wsenvinfor", wsenvinfor);
                return null;

            } return null;
        }
    }

