package com.king.movieshare.utils;


import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class CodeMemory {

    private static ConcurrentHashMap<String,ConcurrentHashMap<String,Object>> memory;

    static{
        memory = new ConcurrentHashMap<String,ConcurrentHashMap<String,Object>>();
    }

    //生成手机验证码
    public static synchronized boolean createCode(String phoneNumber){
        try {
            //生成验证码
            String code = createNCode(4);
            //发送验证码
            SendCode.doSendMessageByTencent(phoneNumber, code);
            //加入memory
            ConcurrentHashMap<String,Object> info = new ConcurrentHashMap<String,Object>();
            info.put("code",code);
            info.put("deadtime",DateUtils.addDateMin(new Date(),15));

            if(memory.get(phoneNumber)==null){
                memory.put(phoneNumber,info);
            }else {
                memory.replace(phoneNumber,info);
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 验证验证码(验证码一次有效)
     * @param phone 手机号
     * @param code 验证码
     * @return
     */
    public static boolean checkCode(String phone,String code){
        ConcurrentHashMap<String,Object> info = memory.get(phone);
        //结构出现异常
        if(info == null || info.get("code")==null || info.get("deadtime")==null){
            if(info != null){
                memory.remove(phone);
            }
            return false;
        }

        Date dead_date = (Date) info.get("deadtime");
        //失效时间小于当前时间
        if(dead_date.before(new Date())){
            return false;
        }

        //验证码不同
        String true_code = (String) info.get("code");
        if(!true_code.equals(code)){
            return false;
        }

        //验证成功，消耗此激活码
        memory.remove(phone);
        return true;
    }

    /**
     * 生成n位随机数的验证码
     * @param n
     * @return
     */
    private static String createNCode(int n){
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for(int i =0;i<n;i++){
            code.append(random.nextInt(10));
        }
        return code.toString();
    }


}
