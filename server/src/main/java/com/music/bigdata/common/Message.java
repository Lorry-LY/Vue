package com.music.bigdata.common;

import com.alibaba.fastjson.JSONObject;

public abstract class Message {

    protected JSONObject jsonObject = new JSONObject();

     abstract public JSONObject getMessage();

}
