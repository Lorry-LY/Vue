package com.music.bigdata.mapper;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.Enum.AnalyzeEnum;
import com.music.bigdata.entity.AnalyzeCount;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
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
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.sort(Sort.by("category"))
                ,Aggregation.project("category","counts")
                ,Aggregation.limit(20)
        );
        return mongoTemplate.aggregate(aggregation,listName,AnalyzeCount.class).getMappedResults();
    }
}
