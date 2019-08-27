package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Standard;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class StandardController {
    @Autowired
    private ILogService ilogService;
    @Autowired
    private IStandardService iStandardService;

    /**
     * @param standard 标准表
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @PostMapping("/standard/update")
    /*
     * 修改标准表
     */
    public ServerResponse updateByPrimaryKeySelective(Standard standard){
        int updateFlagCount = iStandardService.update(standard);
        boolean updateFlag = updateFlagCount>0?true:false;
        if(updateFlag){
            return ServerResponse.createBySuccess("修改成功",iStandardService.selectById(standard.getName()));
        }else{
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }


    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/standard/selectAll")
    /*
     * 查询全部
     */
    public ServerResponse selectAll(){
        List<Standard> standards = iStandardService.selectByAll();
        if(standards!=null){
            return ServerResponse.createBySuccess("查询全部成功",standards);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }

    /**
     * @param name 姓名
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/standard/selectByName/{name}")
    /*
     * 根据name单查
     */
    public ServerResponse selectByName(@PathVariable  String name){
        Standard standard = iStandardService.selectById(name);
        if(standard!=null){
            return ServerResponse.createBySuccess("查询全部成功",standard);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }
}
