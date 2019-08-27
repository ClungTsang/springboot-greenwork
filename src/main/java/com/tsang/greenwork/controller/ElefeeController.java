package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Elefee;
import com.tsang.greenwork.service.IElefeeService;
import com.tsang.greenwork.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class ElefeeController {
    @Autowired
    private IElefeeService iElefeeService;
    @Autowired
    private ILogService iLogService;

    @ResponseBody
    @PostMapping("/elefee/insert")
    /**
     * 新增电费价格表
     */
    public ServerResponse insertElefee(Elefee elefee){
        int insertFlagCount = iElefeeService.insertElefee(elefee);
        boolean insertFlag = insertFlagCount>0?true:false;
        if(insertFlag){
            return ServerResponse.createBySuccess("新增电费标准成功",elefee);
        }else{
            return ServerResponse.createByErrorMessage("新增失败");
        }
    }

    /**
     * @param Range 峰值
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/elefee/delete/{Range}")
    /*
     * 删除电费价格表
     */
    public ServerResponse delete(
            @PathVariable String Range
    ){
        int deleteFlagCount = iElefeeService.deleteEleffByRange(Range);
        boolean deleteFlag = deleteFlagCount > 0 ? true : false;
        if (deleteFlag) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("不存在该峰值");
        }
    }



    /**
     * @param elefee 表
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @PostMapping("/elefee/update")
    /*
     * 修改电费标准表
     */
    public ServerResponse updateByPrimaryKeySelective(Elefee elefee){
        int updateFlagCount = iElefeeService.updateElefee(elefee);
        boolean updateFlag = updateFlagCount>0?true:false;
        if(updateFlag){
            return ServerResponse.createBySuccess("修改成功",iElefeeService.selectByRange(elefee.getRangee()));
        }else{
            return ServerResponse.createByErrorMessage("修改失败");
        }
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/elefee/selectAll")
    /*
     * 查询全部
     */
    public  ServerResponse selectAll(){
        return ServerResponse.createBySuccess("查询成功", iElefeeService.selectAll());
    }

    /**
     * @param Range 峰值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @ResponseBody
    @GetMapping("/elefee/selectByRange/{Range}")
    /*
     * 根据峰值单查
     */
    public ServerResponse selectByRange(
            @PathVariable String Range
    ){
        return ServerResponse.createBySuccess("查询成功",iElefeeService.selectByRange(Range));
    }



}
