package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.User;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IUserService;
import com.tsang.greenwork.service.IWsInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class WSInfoController {
    @Autowired
    private ILogService iLogService;
    @Autowired
    private IWsInforService iWsInforService;
    @Autowired
    private IUserService iUserService;

    /**
     * 新增车间信息
     * @param wsinfor 生产设备id
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/wsinfor/insert")
    public ServerResponse insert(Wsinfor wsinfor){
        Wsinfor wsinfor1 = iWsInforService.selectByPrimaryKey(wsinfor.getWorkshopid());
        if(wsinfor1 == null){
            int insertFlagCount = iWsInforService.insertSelective(wsinfor);
            boolean insertFlag = insertFlagCount>0?true:false;
            if (insertFlag){
                iLogService.insertSelectiveNoTelephone(wsinfor.getWorkshopid()+wsinfor.getWorkshopname(),"增加了新的生产车间");
                return ServerResponse.createBySuccess("插入车间id成功",iWsInforService.selectByPrimaryKey(wsinfor.getWorkshopid()));
            }else{
                return ServerResponse.createByErrorMessage("插入失败");
            }
        }else{
            return ServerResponse.createByErrorMessage("存在该车间");
        }

    }


    /**
     * 删除车间id
     * @param workshopid 生产车间id
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/wsinfor/delete/{workshopid}")
    public ServerResponse delete(
            @PathVariable String workshopid
    ){
        Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
        if(wsinfor!=null) {
            int insertFlagCount = iWsInforService.deleteByWorkshopId(workshopid);
            boolean insertFlag = insertFlagCount>0?true:false;
            if (insertFlag){
                iLogService.insertSelectiveNoTelephone(workshopid,"删除了生产车间");
                return ServerResponse.createBySuccess("删除车间id成功",iWsInforService.selectAll());
            }else{
                return ServerResponse.createByErrorMessage("删除失败");
            }
        }else{
            return ServerResponse.createByErrorMessage("不存在该车间id");
        }

    }

    /**
     * 更改车间信息
     * @param wsinfor 生产设备对象
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/wsinfor/update")
    public ServerResponse update(Wsinfor wsinfor){
        int insertFlagCount = iWsInforService.update(wsinfor);
        boolean insertFlag = insertFlagCount>0?true:false;
        if (insertFlag){
            iLogService.insertSelectiveNoTelephone(wsinfor.getWorkshopid(),"修改了车间信息");
            return ServerResponse.createBySuccess("更新车间信息",iWsInforService.selectByPrimaryKey(wsinfor.getWorkshopid()));
        }else{
            return ServerResponse.createByErrorMessage("更改失败");
        }
    }


    /**
     * 查询全部车间
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/wsinfor/selectAll")
    public ServerResponse selectAll(
    ){
        List<Wsinfor> wsinfors = iWsInforService.selectAll();
        if (wsinfors.isEmpty()){
            return ServerResponse.createByErrorMessage("没有车间");
        }else{
            return ServerResponse.createBySuccess("查询全部成功",wsinfors);
        }
    }

    /**
     * 根据车间id查询
     * @param workshopid 生产车间id
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/wsinfor/selectByid/{workshopid}")
    public ServerResponse selectById(
            @PathVariable String workshopid
    ){
        Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
        if (wsinfor !=null){
            return ServerResponse.createBySuccess("查询车间成功",wsinfor);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }


    /**
     * 修复车间状态
     * @param telephone 电话号码
     * @param workshopid  车间id
     * @param status 车间状态
     * @return
     */
    @GetMapping("/wsinfor/updateFixStatus/{telephone}/{workshopid}/{status}")
    public ServerResponse updateFixStatus(
            @PathVariable String telephone,
            @PathVariable String workshopid,
            @PathVariable String status

    ){
        //0：修复失败
        //1：修复成功
        User user = iUserService.selectByPrimaryKey(telephone);
        if(status.equals("0")){
            //修复失败
            iLogService.insertSelective(user.getUsername(),telephone,"未成功修复车间，建议尽快修复"+workshopid);
            return ServerResponse.createBySuccess(user.getUsername()+telephone,"未成功修复车间，建议尽快修复"+workshopid);
        }else {
            //修复成功
            int updateFlagCount = iWsInforService.updateFixStatus(workshopid);
            boolean updateFlag = updateFlagCount > 0 ? true : false;
            if (updateFlag) {
                    Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
                    iLogService.insertSelective(user.getUsername(), telephone, "修复了车间" + workshopid);
                    return ServerResponse.createBySuccess("修复成功", wsinfor);
            } else {
                return ServerResponse.createByErrorMessage("车间不存在");
            }
        }
    }



}
