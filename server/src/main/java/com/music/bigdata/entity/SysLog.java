package com.music.bigdata.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("syslog")
public class SysLog {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;//id

    @Field("operationUser")
    private String operationUser;//操作人

    @Field("ip")
    private String ip;

    @Field("path")
    private String path;//请求路径

    @Field("date")
    private String date;//日期

    @Field("time")
    private String time;//时间

    @Field("method")
    private String method;//操作方法

    @Field("parameter")
    private String parameter;//方法入参

}

