package com.music.bigdata.controller;

import com.music.bigdata.common.Message;
import com.music.bigdata.service.AnalyzeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Api(tags = "数据分析控制器")
@RestController
@RequestMapping("/analyze")
public class AnalyzeController {

    @Resource
    private AnalyzeService analyzeService;

    @ApiOperation(value = "数量分析",notes = "分析各种数据数量")
    @RequestMapping(value = "/sum",method = RequestMethod.GET,params = {"kind"})
    public Message sumAnalyze(
            @ApiParam(name="kind",required = true,value = "分析表的索引",example = "0")
            @RequestParam(value = "kind")int kind
    ){
        return analyzeService.getSumAnalyze(kind);
    }


}
