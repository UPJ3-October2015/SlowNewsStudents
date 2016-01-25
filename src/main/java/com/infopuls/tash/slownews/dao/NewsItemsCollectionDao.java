package com.infopuls.tash.slownews.dao;

import com.infopuls.tash.slownews.model.Channel;
import com.infopuls.tash.slownews.model.NewsItem;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class NewsItemsCollectionDao {
    private  List<NewsItem> newsList;

    public List<NewsItem> getNewsList() {
        try {
            Channel channel = new ChannelDao().getChannelByRssUrl (new URL("http://feeds.bbci.co.uk/news/rss.xml"));
            return  channel.getItems();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public List <NewsItem>  getArchivNewsList(){
        List <NewsItem> newsItemList = new ArrayList<NewsItem>();

        NewsItem newsItem1 = new NewsItem();
        newsItem1.setTitle("Title for Archiv 1");
        newsItem1.setDescription("Content for Archiv 1");
        newsItem1.setImagePath("../images/fujifilm.jpg");
        newsItemList.add(newsItem1);

        NewsItem newsItem2 = new NewsItem();
        newsItem2.setTitle("Title for Archiv 2");
        newsItem2.setDescription("Content for  Archiv 2");
        newsItem2.setImagePath("../images/gutman-island.jpg");
        newsItemList.add(newsItem2);

        NewsItem newsItem3 = new NewsItem();
        newsItem3.setTitle("Title for Archiv 3");
        newsItem3.setDescription("Content for Archiv 3");
        newsItem3.setImagePath("../images/japan.jpg");
        newsItemList.add(newsItem3);

        return newsItemList;
    }
}
