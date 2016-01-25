package com.infopuls.tash.slownews.convertor;

import com.infopuls.tash.slownews.entity.NewsItemEntity;
import com.infopuls.tash.slownews.model.NewsItem;

public class NewsItemConvertor {

    public NewsItemEntity toNewsItemEntity (NewsItem newsItem) {
        NewsItemEntity newsItemEntity = new NewsItemEntity();
        newsItemEntity.setCategory(newsItem.getCategory());
        newsItemEntity.setAuthor(newsItem.getAuthor());
        newsItemEntity.setImagePath(newsItem.getImagePath());
        newsItemEntity.setCreatedDate(newsItem.getCreatedDate());
        newsItemEntity.setDescription(newsItem.getDescription());
        newsItemEntity.setLink(newsItem.getLink());
        newsItemEntity.setSource(newsItem.getSource());
        newsItemEntity.setTitle(newsItem.getTitle());
        return newsItemEntity;
    }

    public NewsItem toNewsItem (NewsItemEntity newsItemEntity) {
        NewsItem newsItem = new NewsItem();
        newsItem.setCategory(newsItemEntity.getCategory());
        newsItem.setAuthor(newsItemEntity.getAuthor());
        newsItem.setImagePath(newsItemEntity.getImagePath());
        newsItem.setCreatedDate(newsItemEntity.getCreatedDate());
        newsItem.setDescription(newsItemEntity.getDescription());
        newsItem.setLink(newsItemEntity.getLink());
        newsItem.setSource(newsItemEntity.getSource());
        newsItem.setTitle(newsItemEntity.getTitle());
        return newsItem;
    }

}
