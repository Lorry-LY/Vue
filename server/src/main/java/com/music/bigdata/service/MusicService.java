package com.music.bigdata.service;

import com.music.bigdata.common.Message;
import com.music.bigdata.entity.Music;

import java.util.List;

public interface MusicService {

    Message getMusicList(int kind, int index, int pageNumber);
    Message getOverall(int index, int pageNumber);
    Message getStyleList(int kind, int index, int pageNumber);
    Message getEmotionList(int kind, int index, int pageNumber);
    Message getLanguageList(int kind, int index, int pageNumber);
}
