package com.music.bigdata.service.impl;

import com.music.bigdata.entity.Music;
import com.music.bigdata.entity.Record;
import com.music.bigdata.entity.User;
import com.music.bigdata.mapper.BehaviorMapper;
import com.music.bigdata.service.BehaviorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class BehaviorServiceImpl implements BehaviorService {

    @Resource
    private BehaviorMapper behaviorMapper;

    @Override
    public void recordSong(String userID, Music music) {
        Record record = new Record();
        record.setUserID(userID);
        record.setSinger(music.getSinger());
        record.setAlbum(music.getCollection());
        record.setMusicName(music.getName());
        Date date = new Date();
        SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        record.setDate(formatterDate.format(date));
        record.setTime(formatterTime.format(date));
        record.setStyle(behaviorMapper.findStyle(music.getId()));
        record.setEmotion(behaviorMapper.findEmotion(music.getId()));
        record.setLanguage(behaviorMapper.findLanguage(music.getId()));
        behaviorMapper.insertRecord(record);
    }
}
