package com.tsang.greenwork.controller;

import com.alibaba.fastjson.JSONObject;
import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Wsenvinfor;
import com.tsang.greenwork.service.IWsEnvInforSercice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping
@Api(tags = "车间环境信息接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class WSEnvInforController {

    @Autowired
    private IWsEnvInforSercice iWsEnvInforSercice;


    /**
     * 新增环境信息（模拟数据）
     * @param Wsenvinfor  生产车间环境信息
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/insert")
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
     * 查询所有车间的最新环境数据
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectCurrentData")
    @ApiOperation("查询所有车间的最新环境数据")
    public ServerResponse selectCurrentData(){
        List<Wsenvinfor> wsenvinfors = iWsEnvInforSercice.selectCurrentData();
        if(wsenvinfors!=null) {
            return ServerResponse.createBySuccess("所有最新车间环境查询成功", wsenvinfors);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * 根据车间id查询最新车间环境
     * @param workshopid  生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectCurrentDataByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id查询最新车间环境")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse selectCurrentDataByWorkshopid(@PathVariable  String workshopid){
        Wsenvinfor wsenvinfor = iWsEnvInforSercice.selectCurrentDataByWorkshopid(workshopid);
        if(wsenvinfor!=null) {
            return ServerResponse.createBySuccess("最新该车间环境查询成功", wsenvinfor);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * 查询全部环境设备
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectByAll")
    @ApiOperation("查询全部环境设备")
    public  ServerResponse selectByAll(){
        List<Wsenvinfor> wsenvinfors = iWsEnvInforSercice.selectByAll();
        if(wsenvinfors.isEmpty()){
            return ServerResponse.createBySuccessMessage("没有设备信息");
        }else{
            return ServerResponse.createBySuccess("查询成功", iWsEnvInforSercice.selectByAll());
        }
    }

    /**
     * 根据车间id查询所有的环境信息
     * @param workshopid 生产车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id查询所有的环境信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
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
     * 查询当日能耗平均值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectAllAvgDataWithDayByWorkshopid/{workshopid}")
    @ApiOperation("查询当日能耗平均值")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllAvgDataWithDayByWorkshopid(@PathVariable String workshopid){
        JSONObject map = iWsEnvInforSercice.selectAllAvgDataWithDayByWorkshopid(workshopid);
        return map;
    }

    /**
     * 根据车间id查询当天的所属设备运行情况
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectAllAvgDataWithWeekByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id查询当天的所属设备运行情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllAvgDataWithWeekByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.selectAllAvgDataWithWeekByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }


    /**
     * 查询当月的所有设备运行情况
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectAllAvgDataWithMonthByWorkshopid/{workshopid}")
    @ApiOperation("查询当月的所有设备运行情况")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject selectAllAvgDataWithMonthByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.selectAllAvgDataWithMonthByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * 指定车间id 全部可查的
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/ableSelectByWorkshopid/{workshopid}")
    @ApiOperation("指定车间id 全部可查的")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public JSONObject ableSelectByWorkshopid(@PathVariable String workshopid){
        Map map = iWsEnvInforSercice.ableSelectByWorkshopid(workshopid);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject;
    }

    /**
     * 指定车间 指定日期
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/wsenvInfor/selectByWorkshopidWithDate/{workshopid}/{targetDate}")
    @ApiOperation("指定车间 指定日期")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "targetDate",value = "日期",dataType = "String",defaultValue = "20190101",paramType = "path",required = true),
    })
    public List selectByWorkshopidWithDate(
            @PathVariable String workshopid,
            @PathVariable String targetDate
    ){
        return iWsEnvInforSercice.selectByWorkshopidWithDate(workshopid,targetDate);
    }
}
