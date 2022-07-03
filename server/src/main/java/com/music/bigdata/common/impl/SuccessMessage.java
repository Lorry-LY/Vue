package com.music.bigdata.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;

public class SuccessMessage<T> extends Message {
    JSONObject jsonObject = new JSONObject();

    public SuccessMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", null);
    }

    public SuccessMessage(String message, T data) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", data);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}

