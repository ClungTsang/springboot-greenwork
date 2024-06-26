package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Machinfor;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IMachiInforService;
import com.tsang.greenwork.service.IWsInforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Api(tags = "生产设备接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class MachInforController {
    @Autowired
    private IMachiInforService iMachiInforService;
    @Autowired
    private ILogService ilogService;
    @Autowired
    private IWsInforService iWsInforService;


    /**
     * 添加设备信息
     * @param machinfor 设备信息
     * @return
     */
    @PostMapping("/machInfor/insert")
    @ApiOperation("新增设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "machinemodel",value = "设备型号",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "buyingtime",value = "购买日期",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "productivetime",value = "生产日期",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "latitude",value = "纬度",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "longitude",value = "经度",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse insert(Machinfor machinfor){
        String workshopid = machinfor.getWorkshopid();
        Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
        if(wsinfor == null){
            //没有车间可以插入新的设备信息
            return ServerResponse.createByErrorMessage("不可以将该设备信息添加到不存在的车间内，请先添加车间信息");
        }else{
            //判断是否已经存在这个id
            Machinfor machinfor2 = iMachiInforService.selectByMachineid(machinfor.getMachineid());
            if (machinfor2 != null){
                return ServerResponse.createByErrorMessage("设备id已存在");
            }else{
                //设备不存在 可以插入设备信息
                int insertFlagCount = iMachiInforService.insertSelective(machinfor);
                boolean insertFlag = insertFlagCount>0?true:false;
                if(insertFlag){
                    Machinfor machinfor1 = iMachiInforService.selectByMachineid(machinfor.getMachineid());
                    ilogService.insertSelectiveNoTelephone(wsinfor.getWorkshopid(), "新增了设备信息"+machinfor.getMachineid());
                    return ServerResponse.createBySuccess(machinfor.getWorkshopid()+"新增了"+machinfor.getMachineid()+"的设备信息",machinfor1);
                }else{
                    return ServerResponse.createByErrorMessage("新增设备信息失败");
                }
            }
        }
    }


    /**
     * 删除设备信息
     * @param machineid 设备id
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machInfor/delete")
    @ApiOperation("删除设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "query",required = true),
    })
    public ServerResponse delete(
            @RequestParam("machineid")  String machineid
    ){
            int deleteFlagCount = iMachiInforService.deleteByPrimaryKey(machineid);
            boolean deleteFlag = deleteFlagCount > 0 ? true : false;
            if (deleteFlag) {
                ilogService.insertSelectiveNoTelephone(machineid,"该车间被删除了");
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("不存在该车间");
            }
    }


    /**
     * 修改设备信息
     * @param machinfor 修改对象内容
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @PostMapping("/machInfor/updateInfor")
    @ApiOperation("修改设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "machinemodel",value = "设备型号",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "buyingtime",value = "购买日期",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "productivetime",value = "生产日期",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "query",required = true),
            @ApiImplicitParam(name = "latitude",value = "纬度",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "longitude",value = "经度",dataType = "String",paramType = "query"),
    })
    public ServerResponse updateInfo(Machinfor machinfor){
        String machineid = machinfor.getMachineid();
        if(iMachiInforService.selectByMachineid(machineid) == null){
            return ServerResponse.createByErrorMessage("不存在该设备，不允许修改");
        }else {
            //判断是否需要修改车间id
            String workshopid = machinfor.getWorkshopid();
            if (workshopid != null) {
                //需要修改
                Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
                //判断修改的车间 在ws表中存不存在
                if (wsinfor != null) {
                    int insertFlagCount = iMachiInforService.updateByPrimaryKeySelective(machinfor);
                    boolean insertFlag = insertFlagCount > 0 ? true : false;
                    if (insertFlag) {
                        Machinfor machinfor1 = iMachiInforService.selectByMachineid(machinfor.getMachineid());
                        ilogService.insertSelectiveNoTelephone(machinfor1.getMachineid(),"该设备被修改了信息");
                        return ServerResponse.createBySuccess("修改成功", machinfor1);
                    } else {
                        return ServerResponse.createByErrorMessage("修改失败");
                    }
                } else {
                    //不可以更改设备的车间号 因为不存在该车间号
                    return ServerResponse.createByErrorMessage("不可以更改设备的车间号 因为不存在该车间号");
                }
            } else {
                Machinfor machinfor1 = iMachiInforService.selectByMachineid(machinfor.getMachineid());
                ilogService.insertSelectiveNoTelephone(machinfor.getWorkshopid() + machinfor.getMachineid(), "修改了设备信息");
                return ServerResponse.createBySuccess("修改成功", machinfor1);
            }
        }
    }

    /**
     * 查询全部设备
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machInfor/selectByAll")
    @ApiOperation("查询全部设备信息接口")
    public  ServerResponse selectByAll(){
        return ServerResponse.createBySuccess("查询成功", iMachiInforService.selectByAll());
    }

    /**
     * 根据车间id全查询
     * @param workshopid 车间id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/machInfor/selectAllByWorkshopid")
    @ApiOperation("根据车间id查询设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "query",required = true),
    })
    public ServerResponse selectAllByWorkshopid(
            @RequestParam("workshopid") String workshopid
    ){
        return ServerResponse.createBySuccess("查询成功",iMachiInforService.selectAllByWorkshopid(workshopid));
    }


    /**
     * 根据设备id单查询
     * @param machineid 设备id
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/machInfor/selectByMachineid")
    @ApiOperation("根据设备id查询设备信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "query",required = true),
    })
    public ServerResponse selectByMachineId(
            @RequestParam("machineid") String machineid
    ){
        Machinfor machinfor = iMachiInforService.selectByPrimaryKey(machineid);
        if(machinfor!=null) {
            return ServerResponse.createBySuccess("查询成功", iMachiInforService.selectByMachineid(machineid));
        }else{
            return ServerResponse.createByErrorMessage("查询失败  不存在该设备id");
        }
    }
}
