package com.music.bigdata.mapper;


import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.entity.Music;
import com.music.bigdata.entity.Record;
import com.music.bigdata.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class BehaviorMapper {

    @Resource
    private MongoTemplate mongoTemplate;

    public String findStyle(String musicID){
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.project("_id")
                ,Aggregation.match(Criteria.where("_id").is(musicID))
                ,Aggregation.lookup("style", "_id", "_id","List")
                ,Aggregation.unwind("List",false)
                ,Aggregation.project("List.category")
        );
        List<JSONObject> results=mongoTemplate.aggregate(aggregation,"song", JSONObject.class).getMappedResults();
        if(results.size()==0)return null;
        else return results.get(0).get("category").toString();
    }

    public String findEmotion(String id) {
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.project("_id")
                ,Aggregation.match(Criteria.where("_id").is(id))
                ,Aggregation.lookup("emotion", "_id", "_id","List")
                ,Aggregation.unwind("List",false)
                ,Aggregation.project("List.category")
        );
        List<JSONObject> results=mongoTemplate.aggregate(aggregation,"song", JSONObject.class).getMappedResults();
        if(results.size()==0)return null;
        else return results.get(0).get("category").toString();
    }

    public String findLanguage(String id) {
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.project("_id")
                ,Aggregation.match(Criteria.where("_id").is(id))
                ,Aggregation.lookup("language", "_id", "_id","List")
                ,Aggregation.unwind("List",false)
                ,Aggregation.project("List.category")
        );
        List<JSONObject> results=mongoTemplate.aggregate(aggregation,"song", JSONObject.class).getMappedResults();
        if(results.size()==0)return null;
        else return results.get(0).get("category").toString();
    }

    public void insertRecord(Record record) {
        mongoTemplate.insert(record);
    }

    public void insertLogin(User user) {

    }
}
