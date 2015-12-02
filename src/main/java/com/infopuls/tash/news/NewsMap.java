package com.infopuls.tash.news;

import com.infopuls.tash.user.User;

import java.util.Map;

public class NewsMap {
    private Map<User, NewsItem> userNewsMap;


    public NewsMap() {
    }

    public Map<User, NewsItem> getUserNewsMap() {
        return userNewsMap;
    }

    public void setUserNewsMap(Map<User, NewsItem> userNewsMap) {
        this.userNewsMap = userNewsMap;
    }

    

}
