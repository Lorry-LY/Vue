package com.music.bigdata.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@ApiModel(value = "Music")
@Document(collection = "song")
public class Music {

    @Id
    @ApiModelProperty(name = "id",value = "歌曲ID")
    private String id;

    @Field("song_name")
    @ApiModelProperty(name = "song_name",value = "歌曲名称")
    private String name;

    @Field("song_url")
    @ApiModelProperty(name = "song_url",value = "歌曲链接")
    private String url;

    @Field("singer")
    @ApiModelProperty(name = "singer",value = "歌手")
    private String singer;

    @Field("album")
    @ApiModelProperty(name = "album",value = "专辑")
    private String collection;

    @Field("comment")
    @ApiModelProperty(name = "comment",value = "播放量")
    private Integer playCount;

}