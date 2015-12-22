package com.infopuls.tash.slownews.model;

import com.infopuls.tash.slownews.entity.UserEntity;

import java.util.Map;

public class NewsMap {
    private Map<UserEntity, NewsItem> userNewsMap;


    public NewsMap() {
    }

    public Map<UserEntity, NewsItem> getUserNewsMap() {
        return userNewsMap;
    }

    public void setUserNewsMap(Map<UserEntity, NewsItem> userNewsMap) {
        this.userNewsMap = userNewsMap;
    }

    

}
