package com.music.bigdata.exception;

import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/error")
public class BasicErrorController implements ErrorController {

    @RequestMapping(value = "/*", produces = {"text/html"})
    public Message errorHtml(HttpServletRequest request, HttpServletResponse response) {
        int code = response.getStatus();
        System.out.println(code);
        if (404 == code) {
            return new ErrorMessage("error/404");
        } else if (403 == code) {
            return new ErrorMessage("error/403");
        } else if (401 == code) {
            return new ErrorMessage("login");
        } else {
            return new ErrorMessage("error/500");
        }
    }

    @RequestMapping(value ="/*")
    public Message handleError(HttpServletRequest request, HttpServletResponse response) {
        int code = response.getStatus();
        System.out.println(code);
        if (404 == code) {
            return new ErrorMessage("未找到资源");
        } else if (403 == code) {
            return new ErrorMessage("没有访问权限");
        } else if (401 == code) {
            return new ErrorMessage("登录过期");
        } else {
            return new ErrorMessage("服务器错误");
        }
    }

}
