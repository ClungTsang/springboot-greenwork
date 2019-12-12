package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Machinfor;
import com.tsang.greenwork.model.User;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.*;
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
@Api(tags = "用户管理接口")
@CrossOrigin(origins = "*", maxAge = 3600)  //跨域请求
public class UserController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private ILogService iLogService;
    @Autowired
    private IMachiInforService iMachiInforService;
    @Autowired
    private IWsInforService iWsInforService;



    /**
     * 注册用户
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/register/{telephone}/{username}/{account}/{password}/{phonemac}")
    @ApiOperation("注册用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "username",value = "姓名",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "account",value = "账户名称",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "phonemac",value = "手机mac地址",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse checkAccount(
            @PathVariable String telephone,
            @PathVariable String username,
            @PathVariable String account,
            @PathVariable String password,
            @PathVariable String phonemac
    ) throws Exception {
        //得到当前对象
        int countFlagCount = iUserService.countByMac(phonemac);
        boolean countFlag =countFlagCount>0?true:false ;
        User user = iUserService.selectByPrimaryKey(telephone);
        if(countFlag){
            return ServerResponse.createByErrorMessage("mac地址重复，请登录");
        }else{
            if(user==null){
                User user1 = new User(telephone,username,account,password,phonemac);
                int i = iUserService.insertSelective(user1);
                if (i > 0) {
                    //注册成功
                    iLogService.insertSelective(username,telephone,"注册成功");
                    return ServerResponse.createBySuccess("注册成功",user);
                } else {
                    iLogService.insertSelective(user1.getUsername(),user1.getTelephone(),"注册失败");
                    return ServerResponse.createByErrorMessage("注册失败，请检查内容是否合法");
                }
            }else{
                return ServerResponse.createByErrorMessage("电话号码已存在，请登录");
            }
        }
    }


    /**
     * 删除用户
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/delete")
    @ApiOperation("删除用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "request",required = true),
    })
    public ServerResponse deleteAccount(
            @RequestParam("telephone")  String telephone
    ){
        User user = iUserService.selectByPrimaryKey(telephone);
        if(user != null){
            int deleteFlagCount = iUserService.deleteByPrimaryKey(telephone);
            boolean deleteFlag = deleteFlagCount > 0 ? true : false;
            if (deleteFlag) {
                user.setUsername("");
                Machinfor machinfor = new Machinfor(user.getMachineid(),user.getUsername());
                iMachiInforService.updateByPrimaryKeySelective(machinfor);
                iLogService.insertSelective(user.getUsername(),telephone,"该用户被删除了");
                return ServerResponse.createBySuccessMessage("删除成功");
            } else {
                return ServerResponse.createByErrorMessage("删除失败");
            }
        }else{
            return ServerResponse.createByErrorMessage("用户不存在");
        }
    }

    /**
     * 修改用户
     * @param user 修改对象内容
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/user/updateInfor")
    @ApiOperation("修改用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "request",required = true),
            @ApiImplicitParam(name = "username",value = "姓名",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "account",value = "账户名称",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "job",value = "职位",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "hiredate",value = "入职时间",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "phonemac",value = "手机mac",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "checkin",value = "签到次数",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "checked",value = "审核情况",dataType = "String",paramType = "request",allowableValues = "未审核，通过审核"),
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "request"),
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "request"),
    })
    public ServerResponse updateInfor(User user){
        System.out.println(user.getWorkshopid());
        int updateFlagCount = iUserService.updateByPrimaryKeySelective(user);
        User user1 = iUserService.selectByPrimaryKey(user.getTelephone());
        boolean updateFlag = updateFlagCount>0?true:false;
            if(updateFlag){
//                iLogService.insertSelective(user1.getUsername(),user1.getTelephone(),"该用户信息被修改了");
                return ServerResponse.createBySuccess("修改成功",user);
            }else{
                return ServerResponse.createByErrorMessage("修改失败");
            }
    }


    /**
     *
     * 审核请求 同时设置该用户为车间的负责人
     * @param currentTelephone 操作者手机号码
     * @param workshopid 车间id
     * @param machineid 设备id
     * @param telephone 负责人电话
     * @param checked 审核情况 ： 通过审核/不通过审核
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/updateCheck/{currentTelephone}/{machineid}/{telephone}/{checked}/{workshopid}")
    @ApiOperation("审核请求同时设置该用户为车间的负责人接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentTelephone",value = "当前电话",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "machineid",value = "设备id",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "path",required = true),
            @ApiImplicitParam(name = "checked",value = "审核请求",dataType = "String",defaultValue = "通过审核",paramType = "path",required = true),
            @ApiImplicitParam(name = "workshopid",value = "车间id",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse updateCheck(
            @PathVariable  String currentTelephone,
            @PathVariable  String machineid,
            @PathVariable  String telephone,
            @PathVariable  String checked,
            @PathVariable  String workshopid
    ) {
        //检验是否有这个对象
        User user2 = iUserService.selectByPrimaryKey(telephone);
        String username1 = user2.getUsername();
        if (username1 == null) {
            return ServerResponse.createByErrorMessage("找不到操作对象用户");
        } else {
            //检验是否是管理人员
            User user1 = iUserService.selectByPrimaryKey(currentTelephone);
            User user = new User(telephone, checked);
            if (user1 != null) {
                //检验当前号码是否存在
                if (user1.getJob().equals("管理人员")) {
                    if (checked.equals("通过审核")) {
                        //更新审核为 通过审核
                        int updateUserFlagCount = iUserService.updateByPrimaryKeySelective(user);
                        boolean updateFlag = updateUserFlagCount > 0 ? true : false;//判断审核更新结果

                        Machinfor machinfor = new Machinfor( machineid, username1,workshopid);
                        if (updateFlag) { //通过审核

                            //检查分配车间时  是否有相应的车间可以被分配
                            Wsinfor wsinfor = iWsInforService.selectByPrimaryKey(workshopid);
                            if (wsinfor == null) {
                                //不存在该车间
                                return ServerResponse.createByErrorMessage("不存在这个车间");
                            } else {
                                Machinfor machinfor2 = iMachiInforService.selectByMachineid(machineid);
                                if(machinfor2 == null){
                                    return ServerResponse.createByErrorMessage("不存在这个设备信息，请添加相应的设备信息");
                                }else{
                                    //存在车间 并且存在该设备  可以给车间的设备设置负责人
                                    int updateMachinforFlagCount = iMachiInforService.updateByPrimaryKeySelective(machinfor);

                                    User user3 = new User(telephone,machinfor.getMachineid(),machinfor.getWorkshopid());
                                    iUserService.updateByPrimaryKeySelective(user3);
                                    boolean updateMachinforFlag = updateMachinforFlagCount > 0 ? true : false;//判断车间更新结果
                                    if (updateMachinforFlag) {
//                            设置负责人成功
                                        Machinfor machinfor1 = iMachiInforService.selectByMachineid(machineid);
                                        iLogService.insertSelective(user1.getUsername() ,currentTelephone,"车间 "+wsinfor.getWorkshopid()+"的设备"+machineid+" 设置了新的负责人: "+username1);
                                        return ServerResponse.createBySuccess("管理人员:"+user1.getUsername()+" 电话号码:"+currentTelephone+" 给车间:"+wsinfor.getWorkshopid()+"的设备"+machineid+" 设置了新的负责人: "+username1,machinfor1);
                                    } else {
//                            设置负责人失败
                                        return ServerResponse.createByErrorMessage(machinfor.getWorkshopid() + "的" + machinfor.getMachineid() + "新增了负责人失败，可能不存在该用户或者找不到车间id");
                                    }
                                }
                            }
                        } else {
                            //设置负责人失败
                            return ServerResponse.createByErrorMessage("操作" + username1 + currentTelephone + "用户的审核信息失败");
                        }
                    } else if (user.getChecked().equals("不通过审核")) {
                        //不允许通过
                        int updateFlagCount = iUserService.updateByPrimaryKeySelective(user);
                        boolean updateFlag = updateFlagCount > 0 ? true : false;
                        if (updateFlag) {
                            iLogService.insertSelective(user1.getUsername(), user1.getTelephone() ,"该管理人员拒绝给" + username1 + "通过审核");
                            return ServerResponse.createBySuccessMessage(user1.getUsername()+user1.getTelephone() + "管理人员拒绝给" + username1 + "通过审核");
                        } else {
                            return ServerResponse.createByErrorMessage("操作失败，可能不存在该员工");
                        }
                    } else {
                        //未处理
                        return ServerResponse.createByErrorMessage("你没有做任何操作");
                    }
                }else{
                    return ServerResponse.createByErrorMessage("你不是管理人员");
                }
            }else{
                return ServerResponse.createByErrorMessage("你的电话号码有误");
            }
        }
    }

    /**
     * @return status-0成功-1失败 msg信息 data数据
     */
    @GetMapping("/user/selectByAll")
    @ApiOperation("查询全部用户信息")
    public  ServerResponse selectByAll(){
        return ServerResponse.createBySuccess("查询所有信息成功", iUserService.selectByAll());
    }


    /**
     *  在user表中 查询审核情况
     * @param checked 0:未审核/1:通过审核/2:不通过审核/
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/selectByCheck/{checked}")
    @ApiOperation("在user表中查询审核情况接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "checked",value = "审核请求",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse selectByCheck(
            @PathVariable String checked
    ){
        String cnCheck = null;
        switch (checked){
            case "0":cnCheck = "未审核";
                break;
            case "1":cnCheck = "通过审核";
                break;
            case "2":cnCheck = "不通过审核";
        }
        List<User> users = iUserService.selectByCheck(cnCheck);
        if(users.isEmpty()){
            return ServerResponse.createByErrorMessage("找不到该情况用户");
        }else{
            return ServerResponse.createBySuccess("查询审查情况成功",users);
        }
    }


    /**
     * 根据手机号单查询用户
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/selectById/{telephone}")
    @ApiOperation("根据手机号单查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse selectByPrimaryId(
            @PathVariable String telephone
    ){
        User user1 = iUserService.selectByPrimaryKey(telephone);
        Machinfor machinfor = iMachiInforService.selectByUsername(user1.getUsername());
        if(machinfor!=null){
            User user = new User();
            user.setMachineid(machinfor.getMachineid());
            user.setTelephone(telephone);
            iUserService.updateByPrimaryKeySelective(user);
        }
        User user = iUserService.selectByPrimaryKey(telephone);
        if(user == null){
            return ServerResponse.createBySuccessMessage("没有该用户");
        }else{
            return ServerResponse.createBySuccess("查询成功",iUserService.selectByPrimaryKey(telephone));
        }
    }

    /**
     * 签到操作
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @GetMapping("/user/checkIn/{telephone}")
    @ApiOperation("签到操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone",value = "电话号码",dataType = "String",paramType = "path",required = true),
    })
    public ServerResponse updateCheckIn(
            @PathVariable String telephone
    ){
        int checkinFlagCount = iUserService.checkIn(telephone);
        boolean checkinFlag = checkinFlagCount>0?true:false;
        if(checkinFlag){
            return ServerResponse.createBySuccessMessage("签到成功");
        }else{
            return ServerResponse.createByErrorMessage("签到失败");
        }
    }
}
