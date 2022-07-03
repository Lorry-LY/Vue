package com.music.bigdata.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ApiModel(value = "Record")
@Document(collection = "record")
public class Record {

    @Id
    private String id;

    @Field("user_id")
    private String userID;

    @Field("song")
    private String musicName;

    @Field("date")
    private String date;

    @Field("time")
    private String time;

    @Field("singer")
    private String singer;

    @Field("album")
    private String album;

    @Field("language")
    private String language;

    @Field("style")
    private String style;

    @Field("emotion")
    private String emotion;

}
