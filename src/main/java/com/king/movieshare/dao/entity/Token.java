package com.king.movieshare.dao.entity;

import java.util.Date;

public class Token {

    private String phoneNumber;

    private String tokenString;

    private Date deadTime;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDeadTime() {
        return deadTime;
    }

    public String getTokenString() {
        return tokenString;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDeadTime(Date deadTime) {
        this.deadTime = deadTime;
    }

    public void setTokenString(String tokenString) {
        this.tokenString = tokenString;
    }
}
