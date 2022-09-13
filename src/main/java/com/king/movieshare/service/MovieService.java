package com.king.movieshare.service;

import com.alibaba.fastjson.JSONObject;
import com.king.movieshare.dao.RankMapper;
import com.king.movieshare.dao.ResultMapper;
import com.king.movieshare.dao.entity.Rank;
import com.king.movieshare.dao.entity.Result;
import org.hamcrest.number.IsNaN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MovieService {

    @Autowired
    private RankMapper rankMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RpcService rpcService;

    /**
     * 推荐top k个电影
     * @param token
     * @param k
     * @return
     */
    public String red(String token,int k){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String phoneNum = loginService.checkToken(token);
            if (phoneNum == null) {
                //验证失败
                resultMap.put("code", ErrorCode.TokenError.code);
                resultMap.put("msg", ErrorCode.TokenError.text);
                resultMap.put("movies", null);
                return JSONObject.toJSONString(resultMap);
            }
            //启动模型
            boolean isSuc = rpcService.runPyModel(phoneNum,k);
            if(!isSuc){
                //执行失败
                resultMap.put("code", ErrorCode.TopKError.code);
                resultMap.put("msg", ErrorCode.TopKError.text);
                resultMap.put("movies", null);
                return JSONObject.toJSONString(resultMap);
            }

            //查询结果
            Result result = resultMapper.selectTokenByPhoneNumber(phoneNum);
            if (result == null && result.getMovies() != null) {
                resultMap.put("code", ErrorCode.TopKError.code);
                resultMap.put("msg", ErrorCode.TopKError.text);
                resultMap.put("movies", null);
                return JSONObject.toJSONString(resultMap);
            }
            //推荐成功
            resultMap.put("code", ErrorCode.TopKSuccess.code);
            resultMap.put("msg", ErrorCode.TopKSuccess.text);
            resultMap.put("movies", result.getMovies());
            return JSONObject.toJSONString(resultMap);
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code", ErrorCode.TopKError.code);
            resultMap.put("msg", ErrorCode.TopKError.text);
            resultMap.put("movies", null);
            return JSONObject.toJSONString(resultMap);
        }
    }

    /**
     * 用户给电影评分
     * @param token
     * @param movie_id
     * @param rank （0.0~5.0）
     * @return
     */
    public String rank(String token,String movie_id,String rank){
        Map<String, Object> resultMap = new HashMap<>();
        try{

            double rankD = Double.parseDouble(rank);
            if(rankD<1.0 || rankD>5.0 || Double.isNaN(rankD)){
                resultMap.put("code", ErrorCode.TokenError.code);
                resultMap.put("msg", ErrorCode.TokenError.text);
                resultMap.put("movies", null);
                return JSONObject.toJSONString(resultMap);
            }
            String phoneNum = loginService.checkToken(token);
            if (phoneNum == null) {
                //验证失败
                resultMap.put("code", ErrorCode.TokenError.code);
                resultMap.put("msg", ErrorCode.TokenError.text);
                resultMap.put("movies", null);
                return JSONObject.toJSONString(resultMap);
            }

            Rank r = rankMapper.selectTokenByPhoneNumber(phoneNum);

            if(r==null){
                //第一次评分
                r = new Rank();
                r.setPhoneNumber(phoneNum);
                Map<String,String> rankMap = new HashMap<>();
                rankMap.put(movie_id,rank);
                r.setRanks(rankMap);
                if(rankMapper.insert(r)){
                    resultMap.put("code",ErrorCode.RankSuccess.code);
                    resultMap.put("msg",ErrorCode.RankSuccess.text);
                    return JSONObject.toJSONString(resultMap);
                }else {
                    resultMap.put("code",ErrorCode.RankError.code);
                    resultMap.put("msg",ErrorCode.RankError.text);
                    return JSONObject.toJSONString(resultMap);
                }
            }else {
                //在map的基础上添加
                Map<String,String> rankMap = r.getRanks();
                if(rankMap.get(movie_id)==null){
                    rankMap.put(movie_id,rank);
                }else{
                    rankMap.replace(movie_id,rank);
                }
                if(rankMapper.update(r)){
                    resultMap.put("code",ErrorCode.RankSuccess.code);
                    resultMap.put("msg",ErrorCode.RankSuccess.text);
                    return JSONObject.toJSONString(resultMap);
                }else {
                    resultMap.put("code",ErrorCode.RankError.code);
                    resultMap.put("msg",ErrorCode.RankError.text);
                    return JSONObject.toJSONString(resultMap);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            resultMap.put("code",ErrorCode.RankError.code);
            resultMap.put("msg",ErrorCode.RankError.text);
            return JSONObject.toJSONString(resultMap);
        }
    }
}
