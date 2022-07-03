package com.music.bigdata.Enum;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource(value = "/config/analyze.properties",encoding = "UTF-8")
public class AnalyzeEnum {

    @Value("${analyze.list}")
    private List<String> lists = new ArrayList<>();

    public String getCollection(int index){
        if(index<0||index>=lists.size()) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists.get(index);
    }

}
