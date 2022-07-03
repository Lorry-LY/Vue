package com.music.bigdata.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;

public class ErrorMessage  extends Message {

    public ErrorMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
