package com.music.bigdata.controller;

import com.music.bigdata.entity.Music;
import com.music.bigdata.entity.User;
import com.music.bigdata.service.BehaviorService;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "行为控制器")
@RestController
@RequestMapping("/behavior")
public class BehaviorController {

    @Resource
    private BehaviorService behaviorService;

    @ApiOperation(value = "听歌记录",notes = "每次听课都写入数据库")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "music", value = "歌曲", required = true, dataType = "Music")
    })
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public @ResponseBody void recordSong(
            @ApiParam(name="userID",required = false,example = " ")
            @RequestParam(name="userID",required = false) String userID,
            @ApiParam(name="music",required = true)
            @RequestBody Music music
            ) {
        if (userID != null) {
            behaviorService.recordSong(userID, music);
        }
    }


}
