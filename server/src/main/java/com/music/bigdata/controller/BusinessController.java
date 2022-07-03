package com.music.bigdata.controller;

import com.music.bigdata.common.Message;
import com.music.bigdata.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "业务控制器")
@RestController
public class BusinessController {

    @Resource
    private MusicService musicService;

    @ApiOperation(value = "榜单查询",notes = "查询（新歌榜，热歌榜，飙升榜，原创榜）")
    @RequestMapping(value = {"/musicList"},method = RequestMethod.GET)
    public Message musicList(
            @ApiParam(name="kind",required = true,value = "榜单索引")
            @RequestParam(value = "kind") int kind,
            @ApiParam(name="startIndex",required = false,value = "页号",example = "0")
            @RequestParam(value = "startIndex",required = false,defaultValue = "0") int startIndex,
            @ApiParam(name="pageNumber",required = false,value = "页数",example = "20")
            @RequestParam(value = "pageNumber",required = false,defaultValue = "20") int pageNumber
    ){
        return musicService.getMusicList(kind,startIndex,pageNumber);
    }

    @ApiOperation(value = "总榜",notes = "查询总榜单")
    @RequestMapping(value = "/overall",method = RequestMethod.GET)
    public Message overall(
            @ApiParam(name="startIndex",required = false,value = "页号",example = "0")
            @RequestParam(value = "startIndex",required = false,defaultValue = "0") int startIndex,
            @ApiParam(name="pageNumber",required = false,value = "页数",example = "20")
            @RequestParam(value = "pageNumber",required = false,defaultValue = "20") int pageNumber
    ){
        return musicService.getOverall(startIndex,pageNumber);
    }

    @ApiOperation(value = "风格榜",notes = "查询（流行、古典等）榜单")
    @RequestMapping(value = "/styleList",method = RequestMethod.GET)
    public Message kindList(
            @ApiParam(name="kind",required = true,value = "种类索引")
            @RequestParam(value = "kind") int kind,
            @ApiParam(name="startIndex",required = false,value = "页号",example = "0")
            @RequestParam(value = "startIndex",required = false,defaultValue = "0") int startIndex,
            @ApiParam(name="pageNumber",required = false,value = "页数",example = "20")
            @RequestParam(value = "pageNumber",required = false,defaultValue = "20") int pageNumber
    ){
        return musicService.getStyleList(kind,startIndex,pageNumber);
    }

    @ApiOperation(value = "心情榜",notes = "查询不同心情的歌曲榜单")
    @RequestMapping(value = "/emotionList",method = RequestMethod.GET)
    public Message emotionList(
            @ApiParam(name="kind",required = true,value = "心情索引")
            @RequestParam(value = "kind") int kind,
            @ApiParam(name="startIndex",required = false,value = "页号",example = "0")
            @RequestParam(value = "startIndex",required = false,defaultValue = "0") int startIndex,
            @ApiParam(name="pageNumber",required = false,value = "页数",example = "20")
            @RequestParam(value = "pageNumber",required = false,defaultValue = "20") int pageNumber
    ){
        return musicService.getEmotionList(kind,startIndex,pageNumber);
    }

    @ApiOperation(value = "语种榜",notes = "不同语种歌曲内部榜单")
    @RequestMapping(value = "/languageList",method = RequestMethod.GET)
    public Message languageList(
            @ApiParam(name="kind",required = true,value = "语种索引")
            @RequestParam(value = "kind") int kind,
            @ApiParam(name="startIndex",required = false,value = "页号",example = "0")
            @RequestParam(value = "startIndex",required = false,defaultValue = "0") int startIndex,
            @ApiParam(name="pageNumber",required = false,value = "页数",example = "20")
            @RequestParam(value = "pageNumber",required = false,defaultValue = "20") int pageNumber
    ){
        return musicService.getLanguageList(kind,startIndex,pageNumber);
    }




}
