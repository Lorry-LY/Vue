package com.music.bigdata.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;

public class FatalMessage extends Message {

    public FatalMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
