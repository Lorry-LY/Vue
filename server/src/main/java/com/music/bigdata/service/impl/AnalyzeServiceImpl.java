package com.music.bigdata.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import com.music.bigdata.common.impl.SuccessMessage;
import com.music.bigdata.controller.LoggerController;
import com.music.bigdata.entity.AnalyzeCount;
import com.music.bigdata.mapper.AnalyzeMapper;
import com.music.bigdata.service.AnalyzeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnalyzeServiceImpl implements AnalyzeService {

    @Resource
    private AnalyzeMapper analyzeMapper;

    @Resource
    private LoggerController loggerController;


    @Override
    public Message getSumAnalyze(int kind) {
        loggerController.logTest();
        try {
            List<AnalyzeCount> results= analyzeMapper.getSumAnalyze(kind);
            System.out.println(results);
            return new SuccessMessage<>("分析成功",results);
        }catch (Exception e){
            return new ErrorMessage("分析错误");
        }
    }
}
