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

    @Field("path")
    private String path;//请求路径

    @Field("time")
    private String time;//方法执行时间

    @Field("parameter")
    private String parameter;//方法入参

    @Field("title")
    private String title;//操作方法

    @Field("action")
    private String action;//方法描述

    @Field("sysType")
    private Integer sysType;//系统类型

    @Field("opType")
    private Integer opType;//操作类型

}

