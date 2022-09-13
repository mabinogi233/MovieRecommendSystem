package com.king.movieshare.dao.entity;

import java.util.Map;

public class Rank {

    private String phoneNumber;

    private Map<String,String> ranks;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Map<String,String> getRanks() {
        return ranks;
    }

    public void setRanks(Map<String,String> ranks) {
        this.ranks = ranks;
    }
}
