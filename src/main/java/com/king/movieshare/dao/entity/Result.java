package com.king.movieshare.dao.entity;

import java.util.List;
import java.util.Map;

public class Result {

    private String phoneNumber;

    private List<Map<String,String>> movies;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Map<String, String>> getMovies() {
        return movies;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMovies(List<Map<String, String>> movies) {
        this.movies = movies;
    }
}
