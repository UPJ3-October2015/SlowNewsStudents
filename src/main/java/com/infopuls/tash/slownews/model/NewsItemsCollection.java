package com.infopuls.tash.slownews.model;

import com.infopuls.tash.slownews.dao.ChannelDao;
import com.infopuls.tash.slownews.model.Channel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class NewsItemsCollection {

    private  List<NewsItem> newsList;

    public NewsItemsCollection() {
    }

    public NewsItemsCollection(List<NewsItem> newsList) {
        this.newsList = newsList;
    }

    public List<NewsItem> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<NewsItem> newsList) {
        this.newsList = newsList;
    }
}
