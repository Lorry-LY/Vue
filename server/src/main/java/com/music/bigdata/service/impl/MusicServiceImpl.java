package com.music.bigdata.service.impl;

import com.music.bigdata.common.Message;
import com.music.bigdata.common.impl.ErrorMessage;
import com.music.bigdata.common.impl.SuccessMessage;
import com.music.bigdata.entity.Music;
import com.music.bigdata.mapper.BusinessMapper;
import com.music.bigdata.service.MusicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public Message getMusicList(int kind, int index, int pageNumber) {
        try {
            List<Music> results = businessMapper.getMusicList(kind,index,pageNumber);
            return new SuccessMessage<>("查询成功",results);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("错误");
        }

    }

    @Override
    public Message getOverall(int index, int pageNumber) {
        try {
            List<Music> results = businessMapper.getOverall(index,pageNumber);
            return new SuccessMessage<>("查询成功",results);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("错误");
        }

    }

    @Override
    public Message getStyleList(int kind, int index, int pageNumber) {
        try {
            List<Music> results = businessMapper.getStyleList(kind,index,pageNumber);
            return new SuccessMessage<>("查询成功",results);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("错误");
        }
    }

    @Override
    public Message getEmotionList(int kind, int index, int pageNumber) {
        try {
            List<Music> results = businessMapper.getEmotionList(kind,index,pageNumber);
            return new SuccessMessage<>("查询成功",results);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("错误");
        }
    }

    @Override
    public Message getLanguageList(int kind, int index, int pageNumber) {
        try {
            List<Music> results = businessMapper.getLanguageList(kind,index,pageNumber);
            return new SuccessMessage<>("查询成功",results);
        }catch (Exception e){
            e.printStackTrace();
            return new ErrorMessage("错误");
        }
    }
}
