package com.tsang.greenwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Machruntime;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IMachRuntimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
@Api(tags = "环境数据接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class MachRuntimeController {
    @Autowired
    private IMachRuntimeService iMachRuntimeService;

    @Autowired
    private ILogService iLogService;

    /**
     * 全查
     * @param machineid 设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectByMachineid/{machineid}")
    @ApiOperation("查询环境数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
    })
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
     * 根据生产车间id单查
     * @param workshopid 设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id查询环境数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
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
     * 插入环境数据(自动)
     * @param machruntime 设备运行环境
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/insert")
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
     * 查询最新的所有生产设备运行情况
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectCurrentData")
    @ApiOperation("查询最新的所有生产设备运行情况查询环境数据接口")
    public ServerResponse selectCurrentData(){
        List<Machruntime> machruntimes = iMachRuntimeService.selectCurrentData();
        return ServerResponse.createBySuccess("查询最新数据成功",machruntimes);
    }

    /**
     * 根据车间id 查询最新所有设备运行情况
     * @param workshopid 生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectCurrentDataByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id 查询最新所有设备运行情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse selectCurrentDataByWorkshopid(@PathVariable String workshopid){
        List<Machruntime> machruntimes = iMachRuntimeService.selectCurrentDataByWorkshopid(workshopid);
        if(machruntimes!=null){
            return ServerResponse.createBySuccess("查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * 查询当日能耗平均值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectAllAvgDataWithDayByMachineid/{machineid}")
    @ApiOperation("查询当日能耗平均值接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllAvgDataWithDayByMachineid(@PathVariable String machineid){
        JSONObject map = iMachRuntimeService.selectAllAvgDataWithDayByMachineid(machineid);
//        JSONObject jsonObject = new JSONObject(map);
        return map;

    }

    /**
     * 根据车间id查询当天的所属设备运行情况
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectAllAvgDataWithWeekByMachineid/{machineid}")
    @ApiOperation("根据车间id查询当天的所属设备运行情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllAvgDataWithWeekByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.selectAllAvgDataWithWeekByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }


    /**
     * 全查
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectByAll")
    @ApiOperation("全查所有环境数据皆苦")
    public ServerResponse selectByAll(){
        List<Machruntime> machruntimes = iMachRuntimeService.selectByAll();
        if(machruntimes!= null){
            return ServerResponse.createBySuccess("查询成功",machruntimes);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }

    /**
     * 查询当月的所有设备运行情况
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectAllAvgDataWithMonthByMachineid/{machineid}")
    @ApiOperation("查询当月的所有设备运行情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllDataWithMonthByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.selectAllAvgDataWithMonthByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * 指定设备id 全部可查的
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/ableSelectByMachineid/{machineid}")
    @ApiOperation("指定设备id 全部可查的")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject pageByMachineid(@PathVariable String machineid){
        Map map = iMachRuntimeService.ableSelectByMachineid(machineid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * 指定车间 指定日期
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machRuntime/selectByMachineidWithDate/{machineid}/{targetDate}")
    @ApiOperation("查询当日能耗平均值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "targetDate",value = "目标日期",dataType = "String",paramType = "path",required = true),
    })
    public List selectByMachineidWithDate(
            @PathVariable String machineid,
            @PathVariable String targetDate
    ){
        return iMachRuntimeService.selectByMachineidWithDate(machineid,targetDate);
    }





}
