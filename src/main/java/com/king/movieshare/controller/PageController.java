package com.king.movieshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/page")
public class PageController {

    //登陆界面
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    //验证码登陆界面
    @RequestMapping("/codeLoginPage")
    public String codeLoginPage(){
        return "codeLogin";
    }

    //注册界面
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "register";
    }

    //重置密码界面
    @RequestMapping("/resetPage")
    public String resetPage(){
        return "reset";
    }

    //电影推荐界面
    @RequestMapping("/moviePage")
    public String recPage(String token){
        return "movie";
    }

    //评分界面
    @RequestMapping("/rankPage")
    public String rankPage(String token,String id,String name){
        return "rank";
    }

    @RequestMapping("testRec")
    @ResponseBody
    public String testRec(String token){
        System.out.println(token);
        try {
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"code\": \"100\",\"msg\": \"xxxxxx\",\"movies\":[{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"},{\"movie_id\":\"1\",\"title\":\"title\",\"geners\":\"xxxxxxxxxx\"}]}";
    }
}
