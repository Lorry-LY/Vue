package com.music.bigdata.mapper;

import com.mongodb.client.result.UpdateResult;
import com.music.bigdata.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class AccountMapper {

    @Resource
    private MongoTemplate mongoTemplate;

    public UpdateResult updatePhone(String id, String phone){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("phone", phone);
        return mongoTemplate.updateFirst(query, update,User.class);
    }

    public UpdateResult updateEmail(String id, String e_mail){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("e_mail", e_mail);
        return mongoTemplate.updateFirst(query, update,User.class);
    }

    public UpdateResult updatePasswd(String id, String passwd){
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("passwd", passwd);
        return mongoTemplate.updateFirst(query, update,User.class);
    }

    public List<User> findUser(String name){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("adminName").is(name)
                ,Criteria.where("phone").is(name)
                ,Criteria.where("e_mail").is(name));
        Query query = new Query(criteria);
        return mongoTemplate.find(query,User.class);
    }

    public void insertUser(User user){
        mongoTemplate.insert(user);
    }

}
