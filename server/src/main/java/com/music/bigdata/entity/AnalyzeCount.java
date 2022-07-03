package com.music.bigdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class AnalyzeCount {

    @Id
    private String id;

    @Field("category")
    private String name;

    @Field("counts")
    private int count;

}
