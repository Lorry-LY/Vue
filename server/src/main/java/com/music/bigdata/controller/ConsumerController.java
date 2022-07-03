package com.music.bigdata.controller;

import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import com.music.bigdata.entity.User;
import com.music.bigdata.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
            @ApiParam(name="name",required = true,value = "昵称",example = " ")
            @RequestParam(value = "name") String name,
            @ApiParam(name="adminName",required = true,value = "用户名",example = " ")
            @RequestParam(value = "adminName") String adminName,
            @ApiParam(name="passwd",required = true,value = "密码",example = " ")
            @RequestParam(value = "passwd") String passwd,
            @ApiParam(name="phone",required = true,value = "手机号",example = " ")
            @RequestParam(value = "phone") String phone,
            @ApiParam(name="e_mail",required = true,value = "邮箱",example = " ")
            @RequestParam(value = "e_mail") String e_mail
    ){
        User user = new User();
        user.setName(name);
        user.setAdminName(adminName);
        user.setPasswd(passwd);
        user.setPhone(phone);
        user.setE_mail(e_mail);
        return accountService.register(user);
    }

    @ApiOperation(value = "登录",notes = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Message login(
            @ApiParam(name="name",required = true,value = "身份识别（用户名，手机号，邮箱）")
            @RequestParam(value = "name") String text,
            @ApiParam(name="passwd",required = true,value = "密码",example = " ")
            @RequestParam(value = "passwd") String passwd
    ){
        return accountService.login(text,passwd);
    }

    @ApiOperation(value = "更新信息",notes = "用户更新（密码，手机号，邮箱）")
    @RequestMapping(value = "/updateInfo",method = RequestMethod.POST)
    public Message updateInfo(
        @ApiParam(name="id",required = true,value = "用户ID",example = " ")
        @RequestParam(value = "id") String id,
        @ApiParam(name="passwd",required = false,value = "新密码",example = " ")
        @RequestParam(value = "passwd",required = false,defaultValue = "") String passwd,
        @ApiParam(name="phone",required = false,value = "新手机号",example = " ")
        @RequestParam(value = "phone",required = false,defaultValue = "") String phone,
        @ApiParam(name="e_mail",required = false,value = "新邮箱",example = " ")
        @RequestParam(value = "e_mail",required = false,defaultValue = "") String e_mail
    ){
        if(!Objects.equals(passwd, "")){return accountService.updatePasswd(id,passwd);}
        if(!Objects.equals(phone, "")){return accountService.updatePhone(id,phone);}
        if(!Objects.equals(e_mail, "")){return accountService.updateEmail(id,e_mail);}
        return new ErrorMessage("参数错误");
    }

}
