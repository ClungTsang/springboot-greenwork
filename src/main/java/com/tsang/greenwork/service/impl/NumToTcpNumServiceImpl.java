package com.tsang.greenwork.service.impl;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.controller.EnvEquipController;
import com.tsang.greenwork.controller.MachRuntimeController;
import com.tsang.greenwork.controller.WSEnvInforController;
import com.tsang.greenwork.model.Envequip;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.service.IMachRuntimeService;
import com.tsang.greenwork.service.INumToTcpNumService;
import com.tsang.greenwork.service.INumTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Service
public class NumToTcpNumServiceImpl implements INumToTcpNumService {

    @Autowired
    private WSEnvInforController wsEnvInforController;
    @Autowired
    private MachRuntimeController machRuntimeController;
    @Autowired
    private EnvEquipController envEquipController;
    @Autowired
    private INumTransService iNumTransService;
    @Autowired
    private IMachRuntimeService iMachRuntimeService;

    @Override
    public ServerResponse WsInsert1(String tcpNum){
        Map<String,Object> map = iNumTransService.Translate1(tcpNum);
        Set key = map.keySet();
        Iterator<String> it = key.iterator();

        while(it.hasNext()){
            String key1 = it.next();
            if(key1 == "machruntime"){

                ServerResponse insert =null;
                Machruntime machruntime =  (Machruntime)map.get(key1);
                //判断车间id
                String workshopid = machruntime.getMachineid().substring(2, 3);
                switch (workshopid){
                    case "1":
                        machruntime.setWorkshopid("ws001");
                        break;
                    case "2":
                        machruntime.setWorkshopid("ws002");
                        break;
                    case "3":
                        machruntime.setWorkshopid("ws003");
                        break;
                    case "4":
                        machruntime.setWorkshopid("ws004");
                        break;
                    case "5":
                        machruntime.setWorkshopid("ws005");
                        break;
                    case "6":
                        machruntime.setWorkshopid("ws006");
                        break;
                    case "7":
                        machruntime.setWorkshopid("ws007");
                        break;
                    case "8":
                        machruntime.setWorkshopid("ws008");
                        break;
                    case "9":
                        machruntime.setWorkshopid("ws009");
                        break;
                        default: machruntime.setWorkshopid("wsxxx");
                }

                double count = iMachRuntimeService.countByMachineid(machruntime.getMachineid());
                double Nrg = Double.parseDouble(machruntime.getNrgconsumption());
                String n  = null;
                if(count==0.0){
                    n  = String.valueOf(Nrg);
                }else{
                    n = String.valueOf((count+1) * Nrg);
                }
                machruntime.setNrgconsumption(n);

                // 查询上一次所有的数据
                Machruntime machruntime1 = iMachRuntimeService.selectNewlestDataByMachineid(machruntime.getMachineid());
                    if(machruntime1!=null) {
                            //有上次的数据 则判断状态来插入

                            //这次传入值的开关状态
                            String situation = machruntime.getSituation();
                            if (situation.equals("1")) {
                                //本身状态为1
                                //复制上一个能耗
                                machruntime.setFrequency(machruntime1.getFrequency());
                                insert = ServerResponse.createByErrorMessage(machruntime.getMachineid() + "电机设备打开状态");
                            } else {
                                //本身状态不为1
                                if (machruntime1.getSituation().equals("1")) {
                                    //上次状态为1
                                    machruntime.setFrequency(String.valueOf(Double.parseDouble(machruntime1.getFrequency())+1));
                                }else{
                                    //上次状态为2/3
                                    machruntime.setFrequency(machruntime1.getFrequency());
                                }
                                insert = ServerResponse.createByErrorMessage(machruntime.getMachineid() + "电机设备关闭或故障状态");
                        }
                        machRuntimeController.insert(machruntime);
                    }else {
                        //第一次插入
                        machRuntimeController.insert(machruntime);
                        insert = ServerResponse.createBySuccessMessage(machruntime.getMachineid() + "点击设备第一次记录，无法检测状态");
                    }
                return insert;
            }else if(key1=="wsenvinfor"){
                //wsenvinfor
                Wsenvinfor wsenvinfor =  (Wsenvinfor)map.get(key1);
                ServerResponse insert = wsEnvInforController.insert(wsenvinfor);
                return insert;
            }else if(key1 == "envequip"){
                //envequip
                Envequip envequip =  (Envequip)map.get(key1);
                ServerResponse update = envEquipController.update(envequip);
                return update;
            }else{
                return null;
            }
        }
        return null;
    }
    @Override
    public void TranslateDtuData(String tcpNum) {
        System.out.println(iNumTransService.TranslateDtuData(tcpNum));
    }
}
