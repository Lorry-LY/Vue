package com.music.bigdata.common.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;

public class WarningMessage extends Message {
    JSONObject jsonObject = new JSONObject();

    public WarningMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "warning");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
