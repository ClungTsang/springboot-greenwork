package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.model.Machinfor;
import com.tsang.greenwork.model.User;
import com.tsang.greenwork.model.Wsinfor;
import com.tsang.greenwork.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
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
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/register/{telephone}/{username}/{account}/{password}/{phonemac}")
    /*
     * 注册用户
     */
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
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/delete")
    /*
     * 删除用户
     */
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
     * @param user 修改对象内容
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @PostMapping("/user/updateInfor")
    /*
     * 修改用户
     */
    public ServerResponse updateInfor(User user){
        System.out.println(user.getWorkshopid());
        int updateFlagCount = iUserService.updateByPrimaryKeySelective(user);
        User user1 = iUserService.selectByPrimaryKey(user.getTelephone());
        boolean updateFlag = updateFlagCount>0?true:false;
            if(updateFlag){
                iLogService.insertSelective(user1.getUsername(),user1.getTelephone(),"该用户信息被修改了");
                return ServerResponse.createBySuccess("修改成功",user);
            }else{
                return ServerResponse.createByErrorMessage("修改失败");
            }
    }


    /**
     *
     *
     * @param currentTelephone 操作者手机号码
     * @param workshopid 车间id
     * @param machineid 设备id
     * @param telephone 负责人电话
     * @param checked 审核情况 ： 通过审核/不通过审核
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/updateCheck/{currentTelephone}/{machineid}/{telephone}/{checked}/{workshopid}")
    /*
     * 审核请求 同时设置该用户为车间的负责人
     */
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
    @ResponseBody
    @GetMapping("/user/selectByAll")
    public  ServerResponse selectByAll(){
        return ServerResponse.createBySuccess("查询所有信息成功", iUserService.selectByAll());
    }


    /**
     * @param checked 0:未审核/1:通过审核/2:不通过审核/
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/selectByCheck/{checked}")
    /*
     *  在user表中 查询审核情况
     */
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
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/selectById/{telephone}")
    /*
     * 根据手机号单查询用户
     */
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
     * @param telephone 电话号码
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping("/user/checkIn/{telephone}")
    /*
     * 签到操作
     */
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
