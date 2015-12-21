package com.infopuls.tash.slownews.entity;

import java.util.Date;
import java.util.List;

public class NewsItemEntity {

    private String title;
    private String link;
    private String description;
    private String category;
    private Date createdDate;
    private String imagePath;
    private String author;
    private String source;

    public NewsItemEntity() {
    }

    public NewsItemEntity(String description, String title, String imagePath) {
        this.description = description;
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", category='" + category + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
