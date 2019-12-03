package com.tsang.greenwork.controller;

import com.tsang.greenwork.common.ServerResponse;
import com.tsang.greenwork.mapper.UserMapper;
import com.tsang.greenwork.model.User;
import com.tsang.greenwork.service.ILogService;
import com.tsang.greenwork.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
@CrossOrigin (origins = "*",maxAge = 3600) //跨域请求
public class LoginController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ILogService iLogService;

    @Autowired
    private UserMapper userMapper;



    @GetMapping("/login")
    public String page() {
        return "login";
    }

    /**
     * 用户登录方法
     * @param telephone 手机号
     * @param password 密码
     * @return status-0成功-1失败，msg
     */
    @PostMapping("/user/login")
    @ResponseBody
    public ServerResponse login(
            @RequestParam("telephone") String telephone,
            @RequestParam("password") String password
    ) {
        User user = userMapper.selectByPrimaryKey(telephone);
        if(user == null){
            return ServerResponse.createByErrorMessage("账号不存在");
        }else{
            String password1 = user.getPassword();
            if(password1.equals(password)){
                int checkinCountFlag = iLogService.selectCheckin(telephone);
                boolean checkinCount = checkinCountFlag>0?true:false;
                if(!checkinCount){
                    //log日志中当天没有签到记录 登录即可签到
                    iUserService.checkIn(telephone);
                    iLogService.insertSelective(user.getUsername(),telephone,"签到成功");
                }
                iLogService.insertSelective(user.getUsername(),telephone,"登录成功");
                return ServerResponse.createBySuccess("登录成功",user);
            }else{
                return ServerResponse.createByErrorMessage("密码错误");
            }
        }

    }
    /**
     * 用户退出登录
     * @param telephone 手机号
     * @return status-0成功-1失败，msg
     */
    @ResponseBody
    @GetMapping(value = "/user/exit")
    public ServerResponse Exit(
            @RequestParam("telephone") String telephone
    ) {
        User user = iUserService.selectByPrimaryKey(telephone);
        iLogService.insertSelective(user.getUsername(),telephone,"退出了登录");
        return ServerResponse.createBySuccessMessage("退出成功");
        }
}
