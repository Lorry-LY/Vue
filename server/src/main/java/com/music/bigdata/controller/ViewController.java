package com.music.bigdata.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index(){
        return "login";
    }
}
