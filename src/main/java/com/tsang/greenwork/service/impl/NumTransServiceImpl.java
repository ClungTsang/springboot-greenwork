package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.mapper.WsinforMapper;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.INumTransService;
import com.tsang.greenwork.utils.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class NumTransServiceImpl implements INumTransService {

    @Autowired
    private ILogService iLogService;
    @Autowired
    private WsinforMapper wsinforMapper;

    @Override
    public String TranslateDtuData(String dtuData) {
//        Map<String,Object> map = new HashMap();
        String top3 =  dtuData.substring(0,6);
        if(top3.equals("110302")){
            //pm2.5(光照当作pm2.5) 前三对为头消息 第四五对为16进制的光照强度 转为十进制为2.371v 最高可达3w
            // 返回值 11 03 02 09 43 3E 26
            return "pm2.5";
        }else if(top3.equals("110328")){
            //注册包返回值 前三对为头消息
            //11 03 28 77 73 30 30 31 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 3A 24
            //77 73 30 30 31代表ws001
            return "注册包";
        }else{
            //温湿度pm2.5返回值 前三对为头消息
            //01 03 28 11 DF 1E 47 01 70 00 00 00 05 00 06 00 08 00 0B 00 0C 00 0A 00 0B 00 0C 00 0D 00 0E 00 0F 00 10 00 11 00 12 00 13 00 14 76 CC
            //11 DF为温度，1E 47为湿度，01 70光照，00 0B是pm2.5（00 08是pm1.0，00 0C是pm10，都有效）
            return "温湿度";
        }

    }

    @Override
    public Map<String, Object> Translate1(String tcpNum) {
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
                if (situation.equals("1")) {
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
                Wsenvinfor wsenvinfor = new Wsenvinfor(top5, pm, temperature, humidity, ele, String.valueOf(signall));
                map.put("wsenvinfor", wsenvinfor);
                return map;

            } return null;
        }
    }

