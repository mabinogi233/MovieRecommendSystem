package com.king.movieshare.dao;

import com.king.movieshare.dao.entity.Token;
import com.mongodb.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenMapper {

    private DBCollection getTable() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("movie");
        DBCollection userTable = db.getCollection("token");
        return userTable;
    }
    /**
     * 插入令牌
     * @param token
     * @return
     */
    public boolean insert(Token token){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject one_token = new BasicDBObject();
            one_token.put("_id", token.getPhoneNumber());
            one_token.put("phonenumber", token.getPhoneNumber());
            one_token.put("token", token.getTokenString());
            one_token.put("deadtime", token.getDeadTime());
            userTable.insert(one_token);
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
    public Token selectTokenByPhoneNumber(String phoneNumber){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", phoneNumber);
            DBCursor cursor = userTable.find(query);
            Token t = new Token();
            try {
                while (cursor.hasNext()) {
                    DBObject o = cursor.next();
                    t.setPhoneNumber((String)o.get("phonenumber"));
                    t.setDeadTime((Date) o.get("deadtime"));
                    t.setTokenString((String)o.get("token"));
                    return t;
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
     * 令牌查询
     * @param token
     * @return
     */
    public Token selectTokenByTokenStr(String token){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("token", token);
            DBCursor cursor = userTable.find(query);
            Token t = new Token();
            try {
                while (cursor.hasNext()) {
                    DBObject o = cursor.next();
                    t.setPhoneNumber((String)o.get("phonenumber"));
                    t.setDeadTime((Date) o.get("deadtime"));
                    t.setTokenString((String)o.get("token"));
                    return t;
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
     * @param t
     * @return
     */
    public boolean update(Token t){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", t.getPhoneNumber());
            BasicDBObject one_token = new BasicDBObject();
            one_token.put("phonenumber", t.getPhoneNumber());
            one_token.put("deadtime", t.getDeadTime());
            one_token.put("token", t.getTokenString());
            userTable.update(query,one_token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}