package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Elefee;
import com.tsang.greenwork.service.IElefeeService;
import com.tsang.greenwork.service.ILogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
@Api(tags = "电费表管理接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class ElefeeController {
    @Autowired
    private IElefeeService iElefeeService;
    @Autowired
    private ILogService iLogService;

    private static final Logger logger = LoggerFactory.getLogger(ElefeeController.class);

    /**
     * 新增电费价格表
     * @param elefee 表
     * @return
     */
    @PostMapping("/elefee/insert")
    @ApiOperation("添加电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rangee", value = "电费区间",paramType = "query",dataType = "String", defaultValue = "high",required = true),
            @ApiImplicitParam(name = "fee", value = "电费价格",paramType = "query",dataType = "String",required = true)
    })
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
     * 删除电费价格表
     * @param rangee 峰值
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/elefee/delete/{Range}")
    @ApiOperation("删除电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rangee", value = "电费区间",paramType = "path",dataType = "String", defaultValue = "high",required = true),
    })
    public ServerResponse delete(
            @PathVariable String rangee
    ){
        int deleteFlagCount = iElefeeService.deleteEleffByRange(rangee);
        boolean deleteFlag = deleteFlagCount > 0 ? true : false;
        if (deleteFlag) {
            return ServerResponse.createBySuccessMessage("删除成功");
        } else {
            return ServerResponse.createByErrorMessage("不存在该峰值");
        }
    }



    /**
     * 修改电费标准表
     * @param elefee 表
     * @return status-0成功-1失败 msg信息 data数据
     */
    @PostMapping("/elefee/update")
    @ApiOperation("更新电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rangee", value = "电费区间",paramType = "query",dataType = "String", defaultValue = "high",required = true),
            @ApiImplicitParam(name = "fee", value = "电费价格",paramType = "query",dataType = "String",required = true)
    })
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
     * 查询全部
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/elefee/selectAll")
    @ApiOperation("查询所有电费")
    public ServerResponse selectAll(){
        return ServerResponse.createBySuccess("查询成功", iElefeeService.selectAll());
    }

    /**
     * 根据峰值单查
     * @param Range 峰值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/elefee/selectByRange/{Range}")
    @ApiOperation("根据峰值查询电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Range", value = "电费区间",paramType = "path",dataType = "String", defaultValue = "high",required = true),
    })
    public ServerResponse selectByRange(
            @PathVariable String Range
    ){
        return ServerResponse.createBySuccess("查询成功",iElefeeService.selectByRange(Range));
    }

    /**
     * 更新峰值单查
     * @param Range 峰值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/elefee/updateRangeData/{Range}")
    @ApiOperation("根据峰值更新电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Range", value = "电费区间",paramType = "path",dataType = "String", defaultValue = "high",required = true),
    })
    public ServerResponse updateRangeData(
            @PathVariable String Range
    ){
        return ServerResponse.createBySuccess("查询成功",iElefeeService.updateRangeData(Range));
    }

    /**
     * 删除峰值单查
     * @param Range 峰值
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/elefee/deleteRangeData/{Range}")
    @ApiOperation("根据峰值删除电费")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Range", value = "峰值",paramType = "path",dataType = "String", defaultValue = "high",required = true)
    })
    public ServerResponse deleteRangeData(
            @PathVariable String Range
    ){
        return ServerResponse.createBySuccess("查询成功",iElefeeService.deleteRangeData(Range));
    }
}
