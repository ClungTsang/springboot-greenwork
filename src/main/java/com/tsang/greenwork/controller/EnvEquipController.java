package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Envequip;
import com.tsang.greenwork.server.Channelmap;
import com.tsang.greenwork.service.IEnvEquipService;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.utils.HEXUtils;
import io.netty.buffer.Unpooled;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.nio.ByteBuffer;

@RestController
@RequestMapping
@Api(tags = "警报设备管理接口")
@CrossOrigin(origins = "*", maxAge = 3600) //跨域请求
public class EnvEquipController {
    @Autowired
    private IEnvEquipService iEnvEquipService;

    @Autowired
    private ILogService ilogService;

    @Autowired
    private Channelmap channelmap;

    @Value("${DO.FullData.read}")
    private String fullData;

    @Value("${DO.Voltage.read}")
    private String voltageDate;

    @Value("${DO.DO-1.open}")
    private String openFan;

    @Value("${DO.DO-1.close}")
    private String shutFan;

    @Value("${DO.DO-2.open}")
    private String openLight;

    @Value("${DO.DO-2.close}")
    private String shutLight;

    @Value("${DO.DO-3.open}")
    private String openWarn;

    @Value("${DO.DO-3.close}")
    private String shutWarn;

    @Value("${DO.Registration.read")
    private String openRegister;

    /**
     * 新增环境设备
     * @param envequip 监控设备id
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/envEquip/insert")
    @ApiOperation("新增环境设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid", value = "车间id",dataType = "String",paramType = "query",defaultValue = "ws001",required = true),
            @ApiImplicitParam(name = "warn", value = "警报", dataType = "String",paramType = "query",defaultValue = "wa001"),
            @ApiImplicitParam(name = "warnstatus", value = "警报状态",dataType = "String", paramType = "query",defaultValue = "2"),
            @ApiImplicitParam(name = "fan", value = "风扇", dataType = "String",paramType = "query",defaultValue = "fa001"),
            @ApiImplicitParam(name = "fanstatus", value = "风扇状态", dataType = "String",paramType = "query",defaultValue = "2"),
            @ApiImplicitParam(name = "light", value = "光照",dataType = "String", paramType = "query",defaultValue = "lg001"),
            @ApiImplicitParam(name = "lightstatus", value = "光照状态", dataType = "String",paramType = "query",defaultValue = "2"),
            @ApiImplicitParam(name = "fee", value = "电费", dataType = "String",paramType = "query",defaultValue = "fee")
    })
    public ServerResponse insert(Envequip envequip){
            int insertFlagCount = iEnvEquipService.insertSelective(envequip);
            boolean insertFlag = insertFlagCount>0?true:false;
            if(insertFlag){
                ilogService.insertSelectiveNoTelephone(envequip.getWorkshopid(),"新增了"+envequip.getFan()+envequip.getWarn()+"的设备");
                return ServerResponse.createBySuccess("新增成功",envequip);
            }else{
                return ServerResponse.createByErrorMessage("新增失败");
            }
    }


    /**
     * 删除环境设备
     * @param workshopid 监控设备 id
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/envEquip/delete/{workshopid}")
    @ApiOperation("删除环境设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid", value = "车间id", paramType = "path",dataType = "String",defaultValue = "ws001",required = true)
    })
    public ServerResponse delete(
            //从URL中取值
            @PathVariable String workshopid
    ){
            int deleteFlagCount = iEnvEquipService.deleteByPrimaryKey(workshopid);
            boolean deleteFlag = deleteFlagCount > 0 ? true : false;
            if (deleteFlag) {
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("删除失败");
            }
    }


    /**
     * 修改环境设备信息
     * @param envequip 监控设备对象
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/envEquip/update")
    @ApiOperation("修改环境设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid", value = "车间id", paramType = "query",dataType = "String", defaultValue = "ws001",required = true),
            @ApiImplicitParam(name = "warn", value = "警报",paramType = "query",dataType = "String", defaultValue = "wa001"),
            @ApiImplicitParam(name = "fan", value = "风扇",paramType = "query",dataType = "String", defaultValue = "fa001"),
            @ApiImplicitParam(name = "light", value = "光照",paramType = "query",dataType = "String", defaultValue = "lg001"),
            @ApiImplicitParam(name = "fee", value = "电费",paramType = "query",dataType = "String", defaultValue = "fee")
    })
    public ServerResponse update(Envequip envequip){
                int updateFlagCount = iEnvEquipService.updateByPrimaryKeySelective(envequip);
                boolean updateFlag = updateFlagCount > 0 ? true:false;
                if(updateFlag){
                    return ServerResponse.createBySuccess("修改成功",envequip);
                }else{
                    return ServerResponse.createByErrorMessage("用户名错误，修改失败");
                }
    }
    /**
     * 查询全部环境信息
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/envEquip/selectByAll")
    @ApiOperation("查询全部环境设备")
    public  ServerResponse selectByAll(){
        return ServerResponse.createBySuccess("查询成功", iEnvEquipService.selectByAll());
    }

    /**
     * 根据生产id单查询环境设备
     * @param workshopid 生产车间
     * @return  status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/envEquip/selectByWorkshopid/{workshopid}")
    @ApiOperation("根据车间id查询环境设备")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid", value = "车间id", paramType = "path",dataType = "String",defaultValue = "ws001",required = true)
    })
    public ServerResponse selectByWorkshopid(
            @PathVariable String workshopid
    ){
        Envequip envequip = iEnvEquipService.selectByPrimaryKey(workshopid);
        if(envequip!= null){
            return ServerResponse.createBySuccess("根据生产车间id查询成功", envequip);
        }else{
            return ServerResponse.createByErrorMessage("该车间没有环境设备");
        }
    }

    /**
     * 开启/关闭设备
     * @param envequip 车间id 设备id 设备状态
     * @return
     */
    @PostMapping("/envEquip/updateEnvequipByWorkshopid")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "workshopid", value = "车间id", paramType = "query",dataType = "String",defaultValue = "ws001",required = true),
            @ApiImplicitParam(name = "warn", value = "警报id",paramType = "query",dataType = "String", defaultValue = "wa001"),
            @ApiImplicitParam(name = "warnstatus", value = "警报状态", paramType = "query",dataType = "String",allowableValues = "1,2"),
            @ApiImplicitParam(name = "fan", value = "风扇id", paramType = "query",dataType = "String",defaultValue = "fa001"),
            @ApiImplicitParam(name = "fanstatus", value = "风扇状态",paramType = "query",dataType = "String", allowableValues = "1,2"),
            @ApiImplicitParam(name = "light", value = "光照id",paramType = "query",dataType = "String",defaultValue = "lg001"),
            @ApiImplicitParam(name = "lightstatus", value = "光照状态", paramType = "query",dataType = "String",allowableValues = "1,2"),
            @ApiImplicitParam(name = "fee", value = "电费",paramType = "query",dataType = "String", defaultValue = "fee")
    })
    public ServerResponse updateEnvequipByWorkshopid(Envequip envequip){
        int updateFlagCount = iEnvEquipService.updateByPrimaryKeySelective(envequip);
        boolean updateFlag = updateFlagCount>0?true:false;
        if(updateFlag) {
            String lightstatus = envequip.getLightstatus();
            String warnstatus = envequip.getWarnstatus();
            String fanstatus = envequip.getFanstatus();
            if (lightstatus != null && lightstatus.equals("1")) {
                changeEquip(openLight);
                return ServerResponse.createBySuccessMessage("灯光开启成功");
            } if (lightstatus != null && lightstatus.equals("2")) {
                changeEquip(shutLight);
                return ServerResponse.createBySuccessMessage("灯光关闭成功");
            } if (warnstatus != null && warnstatus.equals("1")) {
                changeEquip(openWarn);
                return ServerResponse.createBySuccessMessage("警报开启成功");
            } if (warnstatus != null && warnstatus.equals("2")) {
                changeEquip(shutWarn);
                return ServerResponse.createBySuccessMessage("警报关闭成功");
            } if (fanstatus != null && fanstatus.equals("1")) {
                changeEquip(openFan);
                return ServerResponse.createBySuccessMessage("风扇开启成功");
            } if (fanstatus != null && fanstatus.equals("2")) {
                changeEquip(shutFan);
                return ServerResponse.createBySuccessMessage("风扇关闭成功");
            }
        }else{
            return ServerResponse.createByErrorMessage("操作失败1");
        }
        return ServerResponse.createByErrorMessage("操作失败2");
    }

    public void changeEquip( String equipment){
        byte[] bytes = HEXUtils.hexStringToByte(equipment);
        ByteBuffer buf1 = ByteBuffer.wrap(bytes);
        channelmap.GetChannel().writeAndFlush(Unpooled.wrappedBuffer(buf1));
    }

    @GetMapping("/auto")
    public void autoCheckPm() throws InterruptedException {
        byte[] byte1 = HEXUtils.hexStringToByte(voltageDate);
        ByteBuffer buf1 = ByteBuffer.wrap(byte1);
        channelmap.GetChannel().writeAndFlush(Unpooled.wrappedBuffer(buf1));
        }
    }