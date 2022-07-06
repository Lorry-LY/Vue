package com.music.bigdata.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import com.music.bigdata.entity.User;
import com.music.bigdata.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

@Api(tags = "用户控制器")
@RestController
@RequestMapping("/client")
public class ConsumerController {

    @Resource
    private AccountService accountService;

    @ApiOperation(value = "注册",notes = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Message register(
            @ApiParam(name="data",required = true,value = "信息（昵称，用户名，密码，手机号，邮箱）")
            @RequestBody JSONObject data){
        User user = new User();
        user.setName(data.get("name").toString());
        user.setAdminName(data.get("adminName").toString());
        user.setPasswd(data.get("passwd").toString());
        user.setPhone(data.get("phone").toString());
        user.setE_mail(data.get("e_mail").toString());
        return accountService.register(user);
    }

//    @ApiOperation(value = "登录",notes = "用户登录")
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Message login(
//            @ApiParam(name="name",required = true,value = "身份识别（用户名，手机号，邮箱）")
//            @RequestParam(value = "name") String text,
//            @ApiParam(name="passwd",required = true,value = "密码",example = " ")
//            @RequestParam(value = "passwd") String passwd
//    ){
//        return accountService.login(text,passwd);
//    }

    @ApiOperation(value = "登录",notes = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(
            @ApiParam(name="data",required = true,value = "身份识别（用户名，手机号，邮箱）")
            @RequestBody JSONObject data){
        String text = data.get("text").toString();
        String passwd = data.get("passwd").toString();
        return accountService.login(text,passwd);
    }

    @ApiOperation(value = "登出",notes = "用户登出")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
    public Message logout(
            @ApiParam(name="user",required = true,value = "用户信息")
            @RequestBody User user
    ){
        return accountService.logout(user);
    }


    @ApiOperation(value = "更新信息",notes = "用户更新（密码，手机号，邮箱）")
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public Message updateInfo(
        @ApiParam(name="data",required = true,value = "更新数据（）",example = "")
        @RequestBody JSONObject data
    ){
        String id = data.get("userID").toString();
        if(data.containsKey("passwd")){return accountService.updatePasswd(id,data.get("passwd").toString());}
        if(data.containsKey("phone")){return accountService.updatePhone(id,data.get("phone").toString());}
        if(data.containsKey("e_mail")){return accountService.updateEmail(id,data.get("e_mail").toString());}
        return new ErrorMessage("参数错误");
    }

    @RequestMapping(value = "/findSame",method = RequestMethod.GET)
    public Message findSame(
            @RequestParam(value = "adminName",required = false,defaultValue = "") String adminName,
            @RequestParam(value = "phone",required = false,defaultValue = "") String phone,
            @RequestParam(value = "e_mail",required = false,defaultValue = "") String e_mail
    ){
        if(!Objects.equals(adminName, "")){return accountService.findSameName(adminName);}
        if(!Objects.equals(phone, "")){return accountService.findSamePhone(phone);}
        if(!Objects.equals(e_mail, "")){return accountService.findSameEmail(e_mail);}
        return new ErrorMessage("参数错误");
    }

}
