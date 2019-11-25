package com.tsang.greenwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.service.IWsEnvInforSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class WSEnvInforController {

    @Autowired
    private IWsEnvInforSercice iWsEnvInforSercice;


    /**
     * @param Wsenvinfor  生产车间环境信息
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/insert")
    /*
     * 新增环境信息（模拟数据）
     */
    public ServerResponse insertSelective(Wsenvinfor Wsenvinfor){
        int insertFlagCount = iWsEnvInforSercice.insertSelective(Wsenvinfor);
        boolean insertFlag = insertFlagCount>0?true:false;
        if(insertFlag){
            return ServerResponse.createBySuccess("插入环境信息成功",Wsenvinfor);
        }else{
            return ServerResponse.createByErrorMessage("插入环境信息失败");
        }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectCurrentData")
    /*
     * 查询所有车间的最新环境数据
     */
    public ServerResponse selectCurrentData(){
        List<Wsenvinfor> wsenvinfors = iWsEnvInforSercice.selectCurrentData();
        if(wsenvinfors!=null) {
            return ServerResponse.createBySuccess("所有最新车间环境查询成功", wsenvinfors);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * @param workshopid  生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectCurrentDataByWorkshopid/{workshopid}")
    /*
     * 根据车间id查询最新车间环境
     */
    public ServerResponse selectCurrentDataByWorkshopid(@PathVariable  String workshopid){
        Wsenvinfor wsenvinfor = iWsEnvInforSercice.selectCurrentDataByWorkshopid(workshopid);
        if(wsenvinfor!=null) {
            return ServerResponse.createBySuccess("最新该车间环境查询成功", wsenvinfor);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectByAll")
    /*
     * 查询全部环境设备
     */
    public  ServerResponse selectByAll(){
        List<Wsenvinfor> wsenvinfors = iWsEnvInforSercice.selectByAll();
        if(wsenvinfors.isEmpty()){
            return ServerResponse.createBySuccessMessage("没有设备信息");
        }else{
            return ServerResponse.createBySuccess("查询成功", iWsEnvInforSercice.selectByAll());
        }
    }

    /**
     * @param workshopid 生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectByWorkshopid/{workshopid}")
    /*
     * 根据车间id查询所有的环境信息
     */
    public ServerResponse selectByPrimaryId(
            @PathVariable String workshopid
    ){
        List<Wsenvinfor> wsenvinfors = iWsEnvInforSercice.selectByPrimaryId(workshopid);
        if(wsenvinfors.isEmpty()){
            return ServerResponse.createByErrorMessage("输入的车间id错误或者没有数据");
        }else{
            return ServerResponse.createBySuccess("查询车间"+workshopid+"成功",wsenvinfors);
        }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectAllAvgDataWithDayByWorkshopid/{workshopid}")
    /*
     * 查询当日能耗平均值
     */
    public JSONObject selectAllAvgDataWithDayByWorkshopid(@PathVariable String workshopid){
        JSONObject map = iWsEnvInforSercice.selectAllAvgDataWithDayByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return map;
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectAllAvgDataWithWeekByWorkshopid/{workshopid}")
    /*
     * 根据车间id查询当天的所属设备运行情况
     */
    public JSONObject selectAllAvgDataWithWeekByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.selectAllAvgDataWithWeekByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectAllAvgDataWithMonthByWorkshopid/{workshopid}")
    /*
     * 查询当月的所有设备运行情况
     */
    public JSONObject selectAllAvgDataWithMonthByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.selectAllAvgDataWithMonthByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }
    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/ableSelectByWorkshopid/{workshopid}")
    /*
     * 指定车间id 全部可查的
     */
    public JSONObject ableSelectByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.ableSelectByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/wsenvInfor/selectByWorkshopidWithDate/{workshopid}/{targetDate}")
    /*
     * 指定车间 指定日期
     */
    public List selectByWorkshopidWithDate(
            @PathVariable String workshopid,
            @PathVariable String targetDate
    ){
        return iWsEnvInforSercice.selectByWorkshopidWithDate(workshopid,targetDate);
    }
}
