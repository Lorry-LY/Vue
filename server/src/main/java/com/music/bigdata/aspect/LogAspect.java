package com.music.bigdata.aspect;

import com.alibaba.fastjson.JSONObject;
import com.music.bigdata.common.Message;
import com.music.bigdata.entity.SysLog;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * ..表示包及子包 该方法代表controller层的所有方法  TODO 路径需要根据自己项目定义
     */
    @Pointcut("execution(public * com.music.bigdata.controller..*.*(..))" +
            ",!execution(public * com.music.bigdata.controller.ViewController.*(..))")
    public void controllerMethod() {
    }


    @Before("controllerMethod()")
    public void LogRequestInfo(JoinPoint joinPoint) throws Exception {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        StringBuilder requestLog = new StringBuilder();
        Signature signature = joinPoint.getSignature();
        requestLog.append(((MethodSignature) signature).getMethod().getAnnotation(ApiOperation.class).value()).append("\t")
                .append("请求信息：").append("URL = {").append(request.getRequestURI()).append("},\t")
                .append("请求方式 = {").append(request.getMethod()).append("},\t")
                .append("请求IP = {").append(request.getRemoteHost()).append("},\t")
                .append("类方法 = {").append(signature.getDeclaringTypeName()).append(".")
                .append(signature.getName()).append("},\t");

        // 处理请求参数
        String[] paramNames = ((MethodSignature) signature).getParameterNames();
        Object[] paramValues = joinPoint.getArgs();
        int paramLength = null == paramNames ? 0 : paramNames.length;
        StringBuilder sysLorStr = new StringBuilder();
        if (paramLength == 0) {
            requestLog.append("请求参数 = {} ");
            sysLorStr.append("{} ");
        } else {
            requestLog.append("请求参数 = {");
            sysLorStr.append("{");
            for (int i = 0; i < paramLength - 1; i++) {
                requestLog.append(paramNames[i]).append("=").append(JSONObject.toJSONString(paramValues[i])).append(",");
                sysLorStr.append(paramNames[i]).append("=").append(JSONObject.toJSONString(paramValues[i])).append(",");
            }
            requestLog.append(paramNames[paramLength - 1]).append("=").append(JSONObject.toJSONString(paramValues[paramLength - 1])).append("}");
            sysLorStr.append(paramNames[paramLength - 1]).append("=").append(JSONObject.toJSONString(paramValues[paramLength - 1])).append("}");
        }

        log.info(requestLog.toString());

        SysLog sysLog = new SysLog();
        sysLog.setOperationUser(request.getRemoteUser());
        sysLog.setIp(request.getRemoteHost());
        sysLog.setMethod(signature.getDeclaringTypeName()+"."+signature.getName());
        sysLog.setPath(request.getRequestURI());
        sysLog.setParameter(sysLorStr.toString());
        Date date = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        sysLog.setDate(formatterDate.format(date));
        sysLog.setTime(formatterTime.format(date));
        mongoTemplate.insert(sysLog);
    }

    @AfterReturning(returning = "message", pointcut = "controllerMethod()")
    public void logResultVOInfo(Message message) throws Exception {
        log.info("请求结果：" + message.getMessage().get("code") + "\t" + message.getMessage().get("message"));
    }


}

