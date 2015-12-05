package com.infopuls.tash.news;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@XmlRootElement(name="item")
public class NewsItem {

    @XmlPath("title/text()")
    private String title;

    @XmlPath("link/text()")
    private String link;

    @XmlPath("description/text()")
    private String description;

    @XmlPath("category/text()")
    private String category;

    @XmlPath("pubDate/text()")
    private Date createdDate;

    @XmlAnyElement
    private List<ElementNSImpl> elements;

    private String imagePath;
    private String author;
    private String source;

    public NewsItem() {
    }

    public NewsItem(String description, String title, String imagePath) {
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

    public List<ElementNSImpl> getElements() {
        return elements;
    }

    public void setElements(List<ElementNSImpl> elements) {
        this.elements = elements;
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
