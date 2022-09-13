package com.king.movieshare.dao;


import com.king.movieshare.dao.entity.User;
import com.mongodb.*;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    private DBCollection getTable() throws Exception{
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        DB db = mongoClient.getDB("movie");
        DBCollection userTable = db.getCollection("user");
        return userTable;
    }
    /**
     * 插入用户
     * @param user
     * @return
     */
    public boolean insert(User user){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject one_user = new BasicDBObject();
            one_user.put("_id", user.getPhoneNumber());
            one_user.put("phonenumber", user.getPhoneNumber());
            one_user.put("password", user.getPassword());
            userTable.insert(one_user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 手机号查询
     * @param phoneNumber
     * @return
     */
    public User selectUserByPhoneNumber(String phoneNumber){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", phoneNumber);
            DBCursor cursor = userTable.find(query);
            User u = new User();
            try {
                while (cursor.hasNext()) {
                    DBObject o = cursor.next();
                    u.setPhoneNumber((String)o.get("phonenumber"));
                    u.setPassword((String)o.get("password"));
                    return u;
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
     * @param user
     * @return
     */
    public boolean update(User user){
        try {
            DBCollection userTable = this.getTable();
            BasicDBObject query = new BasicDBObject();
            query.put("phonenumber", user.getPhoneNumber());
            BasicDBObject one_user = new BasicDBObject();
            one_user.put("_id", user.getPhoneNumber());
            one_user.put("phonenumber", user.getPhoneNumber());
            one_user.put("password", user.getPassword());
            userTable.update(query,one_user);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args){
        System.out.println(new UserMapper().selectUserByPhoneNumber("154"));
    }
}
