package com.music.bigdata.mapper;

import com.music.bigdata.Enum.MusicEnum;
import com.music.bigdata.entity.Music;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
public class BusinessMapper {
    
    @Resource
    private MongoTemplate mongoTemplate;
    
    @Resource
    private MusicEnum musicEnum;

    public List<Music> getMusicList(int kind, int index, int pageNumber){
        String listName= musicEnum.getList(kind);
        listName = new String(listName.getBytes(), StandardCharsets.UTF_8);
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.lookup(listName+"_list", "_id", "_id","List")
                ,Aggregation.unwind("List",false)
                ,Aggregation.sort(Sort.Direction.DESC,"comment")
                ,Aggregation.skip(index*pageNumber)
                ,Aggregation.limit(pageNumber)
        );
        return mongoTemplate.aggregate(aggregation,"song", Music.class).getMappedResults();
    }


    public List<Music> getOverall(int index, int pageNumber){
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.sort(Sort.Direction.DESC,"comment"),
                Aggregation.skip(index*pageNumber),
                Aggregation.limit(pageNumber)
        );
        return mongoTemplate.aggregate(aggregation, "song", Music.class).getMappedResults();
    }

    public List<Music> getStyleList(int kind, int index, int pageNumber){
        String listName = musicEnum.getStyle(kind);
        listName = new String(listName.getBytes(), StandardCharsets.UTF_8);
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.lookup("style", "_id", "_id","List")
                ,Aggregation.match(Criteria.where("List.category").is(listName))
                ,Aggregation.unwind("List",false)
                ,Aggregation.sort(Sort.Direction.DESC,"comment")
                ,Aggregation.skip(index*pageNumber)
                ,Aggregation.limit(pageNumber)
        );
        return mongoTemplate.aggregate(aggregation,"song", Music.class).getMappedResults();
    }

    public List<Music> getEmotionList(int kind, int index, int pageNumber){
        String listName = musicEnum.getEmotion(kind);
        listName = new String(listName.getBytes(), StandardCharsets.UTF_8);
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.lookup("emotion", "_id", "_id","List")
                ,Aggregation.match(Criteria.where("List.category").is(listName))
                ,Aggregation.unwind("List",false)
                ,Aggregation.sort(Sort.Direction.DESC,"comment")
                ,Aggregation.skip(index*pageNumber)
                ,Aggregation.limit(pageNumber)
        );
        return mongoTemplate.aggregate(aggregation,"song", Music.class).getMappedResults();
    }


    public List<Music> getLanguageList(int kind, int index, int pageNumber){
        String listName = musicEnum.getLanguage(kind);
        listName = new String(listName.getBytes(), StandardCharsets.UTF_8);
        Aggregation aggregation=Aggregation.newAggregation(
                Aggregation.lookup("language", "_id", "_id","List")
                ,Aggregation.match(Criteria.where("List.category").is(listName))
                ,Aggregation.unwind("List",false)
                ,Aggregation.sort(Sort.Direction.DESC,"comment")
                ,Aggregation.skip(index*pageNumber)
                ,Aggregation.limit(pageNumber)
        );
        return mongoTemplate.aggregate(aggregation,"song", Music.class).getMappedResults();
    }
    
    
}
