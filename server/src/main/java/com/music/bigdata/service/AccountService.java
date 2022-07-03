package com.music.bigdata.service;

import com.music.bigdata.common.Message;
import com.music.bigdata.entity.User;

public interface AccountService {

    Message updatePhone(String id, String phone);

    Message updateEmail(String id, String e_mail);

    Message updatePasswd(String id, String passwd);

    Message login(String name, String passwd);

    Message register(User user);

    Message logout(User user);
}
