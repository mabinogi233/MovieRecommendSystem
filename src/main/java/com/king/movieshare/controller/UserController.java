package com.king.movieshare.controller;

import com.king.movieshare.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/user",produces="text/html;charset=utf-8")
public class UserController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param phoneNum
     * @param password
     * @param type type=0时password为密码，type=1时password为验证码
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam("phonenumber") String phoneNum,
                        @RequestParam("password") String password,
                        @RequestParam("type") int type){
        return loginService.login(phoneNum, password, type);
    }

    /**
     *
     * @param phoneNum
     * @param password
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(@RequestParam("phonenumber") String phoneNum,
                           @RequestParam("password") String password,
                           @RequestParam("code") String code){
        return loginService.register(phoneNum, password, code);
    }

    /**
     *
     * @param phoneNum
     * @param password
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/reset")
    public String reSetPassword(@RequestParam("phonenumber") String phoneNum,
                                @RequestParam("password") String password,
                                @RequestParam("code") String code){
        return loginService.reSetPassword(phoneNum,code,password);
    }

    /**
     *
     * @param token
     * @return
     */
    @ResponseBody
    @RequestMapping("/unlogin")
    public String unLogin(@RequestParam("token") String token){
        return loginService.unLogin(token);
    }

    /**
     *
     * @param phoneNum
     * @param password
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping("/unregister")
    public String unRegister(@RequestParam("phonenumber") String phoneNum,
                             @RequestParam("password") String password,
                             @RequestParam("code") String code){
        return loginService.unRegister(phoneNum, password,code);
    }

    @RequestMapping("/send")
    @ResponseBody
    public void sendMsg(String phoneNum){
        loginService.sendMsg(phoneNum);
    }
}
