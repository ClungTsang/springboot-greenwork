package com.tsang.greenwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IMachRuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class MachRuntimeController {
    @Autowired
    private IMachRuntimeService iMachRuntimeService;

    @Autowired
    private ILogService iLogService;

    /**
     * @return  status-0成功-1失败 msg信息 data数据
     */
//    @ResponseBody
//    @GetMapping("/machRuntime/selectByAll")
    /*
     * 全查
     */
//    public ServerResponse selectByAll(){
//        List<Machruntime> machruntimes = iMachRuntimeService.selectByAll();
//        if(machruntimes!= null){
//            return ServerResponse.createBySuccess("查询成功",machruntimes);
//        }else{
//            return ServerResponse.createByErrorMessage("查询失败");
//        }
//    }


    /**
     * @param machineid 设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectByMachineid/{machineid}")
    /*
     * 全查
     */
    public ServerResponse selectByMachineid(
            @PathVariable  String machineid
    ){
        List<Machruntime> machruntimes = iMachRuntimeService.selectByPrimaryId(machineid);
        if(machruntimes!=null){
            return ServerResponse.createBySuccess("根据设备id查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("设备id不正确");
        }
    }

    /**
     * @param workshopid 设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectByWorkshopid/{workshopid}")
    /*
     * 根据生产车间id单查
     */
    public ServerResponse selectByWorkshopid(
            @PathVariable  String workshopid
    ){
        List<Machruntime> machruntimes = iMachRuntimeService.selectByWorkshopid(workshopid);
        if(machruntimes!=null){
            return ServerResponse.createBySuccess("根据生产id查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("生产id不正确");
        }
    }


    /**
     * @param machruntime 设备运行环境
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/insert")
    /*
     * 插入环境数据(自动)
     */
    public ServerResponse insert(Machruntime machruntime){
            int insertCountFlag = iMachRuntimeService.insertByPrimaryKey(machruntime);
            boolean insertCount = insertCountFlag>0?true:false;
            if(insertCount){
                return ServerResponse.createBySuccess("插入最新数据成功", machruntime);
            }else{
                return ServerResponse.createByErrorMessage("插入最新数失败");
            }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectCurrentData")
    /*
     * 查询最新的所有生产设备运行情况
     */
    public ServerResponse selectCurrentData(){
        List<Machruntime> machruntimes = iMachRuntimeService.selectCurrentData();
        return ServerResponse.createBySuccess("查询最新数据成功",machruntimes);
    }

    /**
     * @param workshopid 生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectCurrentDataByWorkshopid/{workshopid}")
    /*
     * 根据车间id 查询最新所有设备运行情况
     */
    public ServerResponse selectCurrentDataByWorkshopid(@PathVariable String workshopid){
        List<Machruntime> machruntimes = iMachRuntimeService.selectCurrentDataByWorkshopid(workshopid);
        if(machruntimes!=null){
            return ServerResponse.createBySuccess("查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectAllAvgDataWithDayByMachineid/{machineid}")
    /*
     * 查询当日能耗平均值
     */
    public JSONObject selectAllAvgDataWithDayByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.selectAllAvgDataWithDayByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;

    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectAllAvgDataWithWeekByMachineid/{machineid}")
    /*
     * 根据车间id查询当天的所属设备运行情况
     */
    public JSONObject selectAllAvgDataWithWeekByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.selectAllAvgDataWithWeekByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }


    /**
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody

    @GetMapping("/machRuntime/selectByAll")
    /*
     * 全查
     */
    public ServerResponse selectByAll(){
        List<Machruntime> machruntimes = iMachRuntimeService.selectByAll();
        if(machruntimes!= null){
            return ServerResponse.createBySuccess("查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectAllAvgDataWithMonthByMachineid/{machineid}")
    /*
     * 查询当月的所有设备运行情况
     */
    public JSONObject selectAllDataWithMonthByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.selectAllAvgDataWithMonthByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/ableSelectByMachineid/{machineid}")
    /*
     * 指定设备id 全部可查的
     */
    public JSONObject pageByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.ableSelectByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machRuntime/selectByMachineidWithDate/{machineid}/{targetDate}")
    /*
     * 指定车间 指定日期
     */
    public List selectByMachineidWithDate(
            @PathVariable String machineid,
            @PathVariable String targetDate
    ){
        return iMachRuntimeService.selectByMachineidWithDate(machineid,targetDate);
    }





}
