package com.music.bigdata.controller;

import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.SuccessMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志输出测试的controller
 */
@RestController
public class LoggerController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    public Message logTest(){

        logger.debug("=====>测试日志debug级别打印<====");
        logger.info("=====>测试日志info级别打印<=====");
        logger.error("=====>测试日志error级别打印<====");
        logger.warn("=====>测试日志warn级别打印<=====");

        return new SuccessMessage<>("");
    }
}
