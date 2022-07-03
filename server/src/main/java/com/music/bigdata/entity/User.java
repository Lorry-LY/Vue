package com.music.bigdata.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "user")
@ApiModel(value = "User")
public class User {

    @Id
    @ApiModelProperty(name = "id",value = "用户ID")
    private String id;

    @Field("name")
    @ApiModelProperty(name = "name",value = "昵称")
    private String name;

    @Field("adminName")
    @ApiModelProperty(name = "adminName",value = "用户名")
    private String adminName;

    @Field("passwd")
    @ApiModelProperty(name = "passwd",value = "密码")
    private String passwd;

    @Field("phone")
    @ApiModelProperty(name = "phone",value = "手机号")
    private String phone;

    @Field("e_mail")
    @ApiModelProperty(name = "e_mail",value = "邮箱")
    private String e_mail;

}
