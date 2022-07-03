package com.music.bigdata.service;


import com.music.bigdata.entity.Music;
import com.music.bigdata.entity.User;

public interface BehaviorService {

    void recordSong(String userID, Music music);
}
