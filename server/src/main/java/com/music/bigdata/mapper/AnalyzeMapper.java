package com.music.bigdata.mapper;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.Enum.AnalyzeEnum;
import com.music.bigdata.entity.AnalyzeCount;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
public class AnalyzeMapper {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private AnalyzeEnum analyzeEnum;

    public List<AnalyzeCount> getSumAnalyze(int kind) {
        String listName = analyzeEnum.getCollection(kind);
        listName = new String(listName.getBytes(), StandardCharsets.UTF_8);
        return mongoTemplate.findAll(AnalyzeCount.class,listName);

    }
}
