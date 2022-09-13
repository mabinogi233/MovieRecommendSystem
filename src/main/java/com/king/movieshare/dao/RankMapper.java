package com.king.movieshare.dao;


import com.king.movieshare.dao.entity.Rank;
import com.mongodb.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RankMapper {

    private DBCollection getTable() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("movie");
        DBCollection userTable = db.getCollection("ranks");
        return userTable;
    }
    /**
     * 插入用户评分
     * @param rank
     * @return
     */
    public boolean insert(Rank rank){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject one_rank = new BasicDBObject();
            one_rank.put("_id", rank.getPhoneNumber());
            one_rank.put("phonenumber", rank.getPhoneNumber());
            one_rank.put("ranks",rank.getRanks());
            userTable.insert(one_rank);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 令牌查询
     * @param phoneNumber
     * @return
     */
    public Rank selectTokenByPhoneNumber(String phoneNumber){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", phoneNumber);
            DBCursor cursor = userTable.find(query);
            Rank rank = new Rank();
            try {
                while (cursor.hasNext()) {
                    DBObject o = cursor.next();
                    rank.setPhoneNumber((String)o.get("phonenumber"));
                    rank.setRanks((Map<String, String>)o.get("ranks"));
                    return rank;
                }
            } finally {
                cursor.close();
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 按手机号删除用户
     * @param phoneNumber
     * @return
     */
    public boolean delete(String phoneNumber){
        try {
            DBCollection userTable = getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", phoneNumber);
            userTable.remove(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新
     * @param rank
     * @return
     */
    public boolean update(Rank rank){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", rank.getPhoneNumber());

            BasicDBObject one_rank = new BasicDBObject();
            one_rank.put("_id", rank.getPhoneNumber());
            one_rank.put("phonenumber", rank.getPhoneNumber());
            one_rank.put("ranks",rank.getRanks());

            userTable.update(query,one_rank);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}