package com.king.movieshare.service;

//0~99
//登录服务相关的状态码
public enum ErrorCode {
    LoginSuccess("登陆成功","000"),
    NoPhoneNum("未输入ID(手机号)","001"),
    NoPassword("未输入密码","002"),
    NotPhoneNum("手机号格式错误","003"),
    NotRegister("手机号未注册","004"),
    NotSetPassword("未设置密码","005"),
    PasswordError("密码错误","006"),
    UnLoginSuccess("退出登录成功","010"),
    RegisterSuccess("注册成功","020"),
    RegisterError("注册失败","024"),
    UnRegisterSuccess("注销账号成功","030"),
    CheckNumError("验证码错误","021"),
    HasPhoneNumber("账号已存在","022"),
    NoCheckNum("验证码未输入","023"),
    updatePasswordSuccess("密码修改成功","040"),
    updatePasswordError("密码修改失败","041"),
    TokenError("token不存在","060"),
    ServiceError("服务器错误","070"),
    TopKSuccess("top-k推荐成功","100"),
    TopKError("top-k推荐失败","101"),
    RankSuccess("用户评分成功","102"),
    RankError("用户评分失败","103");

    String text;

    String code;

    private ErrorCode(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getText(){
        return text;
    }
}
