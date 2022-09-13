package com.king.movieshare.controller;

import com.king.movieshare.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping(value = "/rem",produces="text/html;charset=utf-8")
public class MovieRemController {

    @Autowired
    private MovieService movieService;

    /**
     * 推荐算法，根据用户推荐k部电影
     * @param token 用户身份令牌
     * @param k 推荐的电影个数
     * @return
     */
    @RequestMapping("/r")
    @ResponseBody
    public String getRem(@RequestParam("token") String token,
                         @RequestParam("num") int k){
        return movieService.red(token, k);
    }

    /**
     * 获取用户反馈
     * @param token 用户身份令牌
     * @param movieId 反馈的电影id
     * @param rank 反馈的电影的评分
     * @return
     */
    @RequestMapping("/rank")
    @ResponseBody
    public String getRank(@RequestParam("token") String token,
                          @RequestParam("movieId") int movieId,
                          @RequestParam("rank") double rank){
        return movieService.rank(token,String.valueOf(movieId),String.valueOf(rank));
    }
}
