package com.music.bigdata.Enum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value = "/config/music.properties",encoding = "UTF-8")
public class MusicEnum {

    @Value("${music.list}")
    private List<String> lists = new ArrayList<>();

    @Value("${music.style}")
    private List<String> styles = new ArrayList<>();

    @Value("${music.emotion}")
    private List<String> emotions = new ArrayList<>();

    @Value("${music.language}")
    private List<String> languages = new ArrayList<>();

    public String getList(int index){
        if(index<0||index>=lists.size()) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists.get(index);
    }

    public String getStyle(int style){
        if(style<0||style>=styles.size()) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return styles.get(style);
    }

    public String getEmotion(int emotion){
        if(emotion<0||emotion>=styles.size()) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emotions.get(emotion);
    }

    public String getLanguage(int language){
        if(language<0||language>=styles.size()) try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return languages.get(language);
    }

}
