package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Standard;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@Api(tags = "环境阈值接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class StandardController {
    @Autowired
    private ILogService ilogService;
    @Autowired
    private IStandardService iStandardService;

    /**
     * 修改标准表
     * @param standard 标准表
     * @return status-0成功-1失败 msg信息 data数据
     */
    @PostMapping("/standard/update")
    @ApiOperation("修改标准表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "检测因子",dataType = "String",paramType = "request",required = true),
            @ApiImplicitParam(name = "high",value = "最高峰",dataType = "String",paramType = "request",required = true),
            @ApiImplicitParam(name = "low",value = "最低值",dataType = "String",paramType = "request",required = true),
    })
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
     * 查询全部
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/standard/selectAll")
    @ApiOperation("查询标准表")
    public ServerResponse selectAll(){
        List<Standard> standards = iStandardService.selectByAll();
        if(standards!=null){
            return ServerResponse.createBySuccess("查询全部成功",standards);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }

    /**
     * 根据name单查
     * @param name 姓名
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/standard/selectByName/{name}")
    @ApiOperation("根据name单查")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "检测因子",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse selectByName(@PathVariable  String name){
        Standard standard = iStandardService.selectById(name);
        if(standard!=null){
            return ServerResponse.createBySuccess("查询全部成功",standard);
        }else{
            return ServerResponse.createByErrorMessage("查询失败");
        }
    }
}
