package com.king.movieshare.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ItemsUtils {

    /**
     * MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     */
    public static String EncoderByMd5(String str){
        try {
            //确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder encoder = Base64.getEncoder();
            //加密后的字符串
            return encoder.encodeToString(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }
}
