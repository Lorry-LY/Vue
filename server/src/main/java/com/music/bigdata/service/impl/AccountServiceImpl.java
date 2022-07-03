package com.music.bigdata.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import com.music.bigdata.common.impl.SuccessMessage;
import com.music.bigdata.entity.User;
import com.music.bigdata.mapper.AccountMapper;
import com.music.bigdata.mapper.BehaviorMapper;
import com.music.bigdata.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private BehaviorMapper behaviorMapper;

    @Override
    public Message updatePhone(String id, String phone) {
        try {
            UpdateResult result = accountMapper.updatePhone(id,phone);
            if(result.getMatchedCount()==0)return new ErrorMessage("不存在该用户");
            return new SuccessMessage<>("更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("更新失败");
        }
    }

    @Override
    public Message updateEmail(String id, String e_mail) {
        try {
            UpdateResult result = accountMapper.updateEmail(id,e_mail);
            if(result.getMatchedCount()==0)return new ErrorMessage("不存在该用户");
            return new SuccessMessage<>("更新成功");
        }catch (Exception ignored){
            return new ErrorMessage("更新失败");
        }
    }

    @Override
    public Message updatePasswd(String id, String passwd) {
        try {
            UpdateResult result = accountMapper.updatePasswd(id,passwd);
            if(result.getModifiedCount()==0)return new ErrorMessage("不存在该用户");
            return new SuccessMessage<>("更新成功");
        }catch (Exception ignored){
            return new ErrorMessage("更新失败");
        }
    }

    @Override
    public Message login(String name, String passwd) {
        List<User> users = accountMapper.findUser(name);
        if(users.size()==0)return new ErrorMessage("没有该用户");
        if(users.size()!=1)return new ErrorMessage("数据库错误");
        if (!users.get(0).getPasswd().equals(passwd))return new ErrorMessage("密码错误");
        behaviorMapper.insertLogin(users.get(0));
        return new SuccessMessage<>("登陆成功",users.get(0));
    }

    @Override
    public Message register(User user) {
        try {
            accountMapper.insertUser(user);
            return new SuccessMessage<>("注册成功",user);
        }catch (Exception e){
            return new ErrorMessage("已存在该用户");
        }
    }

    private Message checkIntegrity(User user){
        if(user.getName()==null) return new ErrorMessage("昵称错误");
        if(user.getAdminName()==null) return new ErrorMessage("用户名错误");
        if(user.getPhone()==null )return new ErrorMessage("电话错误");
        if(user.getE_mail()==null)return new ErrorMessage("邮箱错误");
        return new SuccessMessage<>("", "");
    }

}
