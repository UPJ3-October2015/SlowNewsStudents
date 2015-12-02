package com.infopuls.tash.news;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
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

    @XmlPath("media/@url")// /root/@id/text()
    private String imagePath;


    private String author;
    private File image;
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }


    public List <NewsItem>  getNewsList() {
        List<NewsItem> newsItemList = null;
        try {
            Channel channel = getChannelByRssUrl (new URL("http://feeds.bbci.co.uk/news/rss.xml"));
            return  channel.getItems();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return newsItemList;
    }

    public  Channel getChannelByRssUrl (URL rss) {
        Channel channel = null;
        try {

            JAXBContext context = JAXBContextFactory.createContext(new Class[]{Channel.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            channel = (Channel) unmarshaller.unmarshal(rss);
            System.out.println(channel.toString());
            for ( NewsItem item : channel.getItems() ){
                System.out.println(item.toString());
            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(channel, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    public List <NewsItem>  getNewsList_old(){
        List <NewsItem> newsItemList = new  ArrayList <NewsItem> ();

        NewsItem newsItem1 = new NewsItem();
        newsItem1.setTitle("Title for news 1");
        newsItem1.setDescription("Content for News1");
        newsItem1.setImagePath("images/fujifilm.jpg");
        newsItemList.add(newsItem1);

        NewsItem newsItem2 = new NewsItem();
        newsItem2.setTitle("Title for news 2");
        newsItem2.setDescription("Content for News2");
        newsItem2.setImagePath("/images/gutman-island.jpg");
        newsItemList.add(newsItem2);

        NewsItem newsItem3 = new NewsItem();
        newsItem3.setTitle("Title for news 3");
        newsItem3.setDescription("Content for News3");
        newsItem3.setImagePath("/images/japan.jpg");
        newsItemList.add(newsItem3);

        return newsItemList;
    }

    public List <NewsItem>  getArchivNewsList(){
        List <NewsItem> newsItemList = new  ArrayList <NewsItem> ();

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
