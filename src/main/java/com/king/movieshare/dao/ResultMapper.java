package com.king.movieshare.dao;


import com.king.movieshare.dao.entity.Result;
import com.mongodb.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ResultMapper {

    private DBCollection getTable() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("movie");
        DBCollection userTable = db.getCollection("result");
        return userTable;
    }
    /**
     * 插入结果
     * @param result
     * @return
     */
    public boolean insert(Result result){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject one_movie = new BasicDBObject();
            one_movie.put("_id", result.getPhoneNumber());
            one_movie.put("phonenumber", result.getPhoneNumber());
            one_movie.put("movies",result.getMovies());
            userTable.insert(one_movie);
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
    public Result selectTokenByPhoneNumber(String phoneNumber){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", phoneNumber);
            DBCursor cursor = userTable.find(query);
            Result result = new Result();
            try {
                while (cursor.hasNext()) {

                    DBObject o = cursor.next();
                    result.setPhoneNumber((String)o.get("phonenumber"));
                    result.setMovies((List<Map<String, String>>)o.get("movies"));

                    for(Map<String,String> map:result.getMovies()){
                        System.out.println("******************************");
                        for(Map.Entry<String,String> e:map.entrySet()){
                            System.out.println(e.getKey()+":"+e.getValue());
                        }
                    }

                    return result;
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
     * @param result
     * @return
     */
    public boolean update(Result result){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", result.getPhoneNumber());

            BasicDBObject one_movie = new BasicDBObject();
            one_movie.put("_id", result.getPhoneNumber());
            one_movie.put("phonenumber", result.getPhoneNumber());
            one_movie.put("movies",result.getMovies());

            userTable.update(query,one_movie);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}