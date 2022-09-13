package com.king.movieshare.service;

import com.alibaba.fastjson.JSONObject;
import com.king.movieshare.dao.TokenMapper;
import com.king.movieshare.dao.UserMapper;
import com.king.movieshare.dao.entity.Token;
import com.king.movieshare.dao.entity.User;
import com.king.movieshare.utils.CodeMemory;
import com.king.movieshare.utils.DateUtils;
import com.king.movieshare.utils.ItemsUtils;
import com.king.movieshare.utils.PhoneNumberCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenMapper tokenMapper;

    /**
     * 登录
     * @param phoneNum 手机号
     * @param password 密码或验证码
     * @param type type=0 则password为密码， type=1则password为手机验证码
     * @return
     */
    public String login(String phoneNum,String password,int type){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if(phoneNum==null){
                //未输入手机号
                resultMap.put("code", ErrorCode.NoPhoneNum.code);
                resultMap.put("token","");
                resultMap.put("msg", ErrorCode.NoPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(password==null){
                //未输入密码
                if(type==0) {
                    resultMap.put("code", ErrorCode.NoPassword.code);
                    resultMap.put("token", "");
                    resultMap.put("msg", ErrorCode.NoPassword.text);
                    return JSONObject.toJSONString(resultMap);
                }else {
                    //未输入验证码
                    resultMap.put("code", ErrorCode.NoCheckNum.code);
                    resultMap.put("token", "");
                    resultMap.put("msg", ErrorCode.NoCheckNum.text);
                    return JSONObject.toJSONString(resultMap);
                }
            }
            if(!PhoneNumberCheck.isPhoneLegal(phoneNum)){
                //手机号格式错误
                resultMap.put("code", ErrorCode.NotPhoneNum.code);
                resultMap.put("token","");
                resultMap.put("msg", ErrorCode.NotPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            User u = userMapper.selectUserByPhoneNumber(phoneNum);
            if(u==null){
                //账号未注册
                resultMap.put("code", ErrorCode.NotRegister.code);
                resultMap.put("token","");
                resultMap.put("msg", ErrorCode.NotRegister.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(type==0){
                String true_password = u.getPassword();
                if(true_password==null){
                    //密码未设置
                    resultMap.put("code", ErrorCode.NotSetPassword.code);
                    resultMap.put("token","");
                    resultMap.put("msg", ErrorCode.NotSetPassword.text);
                    return JSONObject.toJSONString(resultMap);
                }
                if(!true_password.equals(password)){
                    //密码错误
                    resultMap.put("code", ErrorCode.PasswordError.code);
                    resultMap.put("token","");
                    resultMap.put("msg", ErrorCode.PasswordError.text);
                    return JSONObject.toJSONString(resultMap);
                }
            }else {
                boolean isSucc = CodeMemory.checkCode(phoneNum,password);
                if(!isSucc){
                    //验证码错误
                    resultMap.put("code", ErrorCode.CheckNumError.code);
                    resultMap.put("token","");
                    resultMap.put("msg", ErrorCode.CheckNumError.text);
                    return JSONObject.toJSONString(resultMap);
                }
            }
            //登录成功
            String token = create_token(phoneNum);
            Token t = new Token();
            t.setPhoneNumber(phoneNum);
            t.setTokenString(token);
            t.setDeadTime(DateUtils.addDateHour(new Date(),24*30));
            //加入token数据库
            if(tokenMapper.selectTokenByPhoneNumber(phoneNum)!=null){
                tokenMapper.update(t);
            }else {
                tokenMapper.insert(t);
            }
            resultMap.put("code", ErrorCode.LoginSuccess.code);
            resultMap.put("msg", ErrorCode.LoginSuccess.text);
            resultMap.put("token",token);
            return JSONObject.toJSONString(resultMap);
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", ErrorCode.ServiceError.code);
            resultMap.put("msg", ErrorCode.ServiceError.text);
            resultMap.put("token","");
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 注册
     * @param phoneNum 手机号码
     * @param password 密码
     * @param code 手机验证码
     * @return
     */
    public String register(String phoneNum,String password,String code){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if (phoneNum == null) {
                //未输入手机号
                resultMap.put("code", ErrorCode.NoPhoneNum.code);
                resultMap.put("msg", ErrorCode.NoPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(password==null) {
                //未输入密码
                resultMap.put("code", ErrorCode.NoPassword.code);
                resultMap.put("msg", ErrorCode.NoPassword.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(code==null){
                //未输入验证码
                resultMap.put("code", ErrorCode.NoCheckNum.code);
                resultMap.put("msg", ErrorCode.NoCheckNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(!PhoneNumberCheck.isPhoneLegal(phoneNum)){
                //手机号格式错误
                resultMap.put("code", ErrorCode.NotPhoneNum.code);
                resultMap.put("msg", ErrorCode.NotPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            boolean isSucc = CodeMemory.checkCode(phoneNum,code);
            if(!isSucc){
                //验证码错误
                resultMap.put("code", ErrorCode.CheckNumError.code);
                resultMap.put("msg", ErrorCode.CheckNumError.text);
                return JSONObject.toJSONString(resultMap);
            }
            //验证成功，开始注册
            //账号已存在
            if (userMapper.selectUserByPhoneNumber(phoneNum)!=null){
                resultMap.put("code", ErrorCode.HasPhoneNumber.code);
                resultMap.put("msg", ErrorCode.HasPhoneNumber.text);
                return JSONObject.toJSONString(resultMap);
            }
            User u = new User();
            u.setPhoneNumber(phoneNum);
            u.setPassword(password);
            if(userMapper.insert(u)) {
                //注册成功
                resultMap.put("code", ErrorCode.RegisterSuccess.code);
                resultMap.put("msg", ErrorCode.RegisterSuccess.text);
                return JSONObject.toJSONString(resultMap);
            }else{
                resultMap.put("code", ErrorCode.RegisterError.code);
                resultMap.put("msg", ErrorCode.RegisterError.text);
                return JSONObject.toJSONString(resultMap);
            }

        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", ErrorCode.ServiceError.code);
            resultMap.put("msg", ErrorCode.ServiceError.text);
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 找回密码(设置新密码)
     * @param phoneNum 手机号码
     * @param code 手机验证码
     * @param newPassword 新密码
     * @return
     */
    public String reSetPassword(String phoneNum,String code,String newPassword){
        Map<String,Object> resultMap = new HashMap<>();
        try {
            if (phoneNum == null) {
                //未输入手机号
                resultMap.put("code", ErrorCode.NoPhoneNum.code);
                resultMap.put("msg", ErrorCode.NoPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(newPassword == null) {
                //未输入密码
                resultMap.put("code", ErrorCode.NoPassword.code);
                resultMap.put("msg", ErrorCode.NoPassword.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(code==null){
                //未输入验证码
                resultMap.put("code", ErrorCode.NoCheckNum.code);
                resultMap.put("msg", ErrorCode.NoCheckNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(!PhoneNumberCheck.isPhoneLegal(phoneNum)){
                //手机号格式错误
                resultMap.put("code", ErrorCode.NotPhoneNum.code);
                resultMap.put("msg", ErrorCode.NotPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            boolean isSucc = CodeMemory.checkCode(phoneNum,code);
            if(!isSucc){
                //验证码错误
                resultMap.put("code", ErrorCode.CheckNumError.code);
                resultMap.put("msg", ErrorCode.CheckNumError.text);
                return JSONObject.toJSONString(resultMap);
            }
            //验证成功，开始注册
            //账号不存在
            if (userMapper.selectUserByPhoneNumber(phoneNum)==null){
                resultMap.put("code", ErrorCode.NotRegister.code);
                resultMap.put("msg", ErrorCode.NotRegister.text);
                return JSONObject.toJSONString(resultMap);
            }
            User u = new User();
            u.setPhoneNumber(phoneNum);
            u.setPassword(newPassword);
            if(userMapper.update(u)) {
                //修改成功
                tokenMapper.delete(phoneNum);
                resultMap.put("code", ErrorCode.updatePasswordSuccess.code);
                resultMap.put("msg", ErrorCode.updatePasswordSuccess.text);
                return JSONObject.toJSONString(resultMap);
            }else{
                resultMap.put("code", ErrorCode.updatePasswordError.code);
                resultMap.put("msg", ErrorCode.updatePasswordError.text);
                return JSONObject.toJSONString(resultMap);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", ErrorCode.ServiceError.code);
            resultMap.put("msg", ErrorCode.ServiceError.text);
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 退出登录
     * @param token
     * @return
     */
    public String unLogin(String token){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            Token t = tokenMapper.selectTokenByTokenStr(token);
            if(t!=null){
                tokenMapper.delete(t.getPhoneNumber());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        resultMap.put("code", ErrorCode.UnLoginSuccess.code);
        resultMap.put("msg", ErrorCode.UnLoginSuccess.text);
        return JSONObject.toJSONString(resultMap);
    }

    /**
     * 删除账号
     * @param phoneNum
     * @param password
     * @param code
     * @return
     */
    public String unRegister(String phoneNum,String password,String code){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            if (phoneNum == null) {
                //未输入手机号
                resultMap.put("code", ErrorCode.NoPhoneNum.code);
                resultMap.put("msg", ErrorCode.NoPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(password == null) {
                //未输入密码
                resultMap.put("code", ErrorCode.NoPassword.code);
                resultMap.put("msg", ErrorCode.NoPassword.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(code==null){
                //未输入验证码
                resultMap.put("code", ErrorCode.NoCheckNum.code);
                resultMap.put("msg", ErrorCode.NoCheckNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(!PhoneNumberCheck.isPhoneLegal(phoneNum)){
                //手机号格式错误
                resultMap.put("code", ErrorCode.NotPhoneNum.code);
                resultMap.put("msg", ErrorCode.NotPhoneNum.text);
                return JSONObject.toJSONString(resultMap);
            }
            boolean isSucc = CodeMemory.checkCode(phoneNum,code);
            if(!isSucc){
                //验证码错误
                resultMap.put("code", ErrorCode.CheckNumError.code);
                resultMap.put("msg", ErrorCode.CheckNumError.text);
                return JSONObject.toJSONString(resultMap);
            }
            //账号不存在
            User u = userMapper.selectUserByPhoneNumber(phoneNum);
            if (u==null){
                resultMap.put("code", ErrorCode.NotRegister.code);
                resultMap.put("msg", ErrorCode.NotRegister.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(u.getPassword()==null){
                //密码未设置
                resultMap.put("code", ErrorCode.NotSetPassword.code);
                resultMap.put("msg", ErrorCode.NotSetPassword.text);
                return JSONObject.toJSONString(resultMap);
            }
            if(!u.getPassword().equals(password)){
                //密码错误
                resultMap.put("code", ErrorCode.PasswordError.code);
                resultMap.put("msg", ErrorCode.PasswordError.text);
                return JSONObject.toJSONString(resultMap);
            }
            //开始删除数据库中的用户信息
            tokenMapper.delete(phoneNum);
            userMapper.delete(phoneNum);
            //注销成功
            resultMap.put("code", ErrorCode.UnRegisterSuccess.code);
            resultMap.put("msg", ErrorCode.UnRegisterSuccess.text);
            return JSONObject.toJSONString(resultMap);
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", ErrorCode.ServiceError.code);
            resultMap.put("msg", ErrorCode.ServiceError.text);
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 生成token
     * @param code
     * @return
     */
    private String create_token(String code){
        String token = code + new Date().toString();
        //采用循环，防止生成俩个相同的token
        do {
            //进行MD5加密
            token = ItemsUtils.EncoderByMd5(token);
        }while (tokenMapper.selectTokenByTokenStr(token)!=null);
        return token;
    }

    /**
     * 检查token，返回phoneNumber
     * @param token
     * @return
     */
    public String checkToken(String token){
        try {
            Token u = tokenMapper.selectTokenByTokenStr(token);
            if (u != null && u.getTokenString()!=null && u.getPhoneNumber()!=null && u.getDeadTime()!=null) {
                if(u.getDeadTime().after(new Date())){
                    return u.getPhoneNumber();
                }
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param phoneNum
     * @return
     */
    public void sendMsg(String phoneNum){
        CodeMemory.createCode(phoneNum);
    }
}
