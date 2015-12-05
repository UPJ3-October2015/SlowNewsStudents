package com.infopuls.tash.news;

import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.net.URL;
import java.util.List;


@XmlRootElement(name="rss")
public class Channel {

    @XmlPath("channel/title/text()")
    private String title;

    @XmlPath("channel/link/text()")
    private String link;

    @XmlPath("channel/description/text()")
    private String description;

    @XmlPath("channel/language/text()")
    private String language;

    @XmlPath("channel/pubDate/text()")
    private String pubDate;

    @XmlPath("channel/lastBuildDate/text()")
    private String lastBuildDate;

    @XmlPath("channel/item")
    List<NewsItem> items;

    public Channel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate) {
        this.lastBuildDate = lastBuildDate;
    }

    public List<NewsItem> getItems() {
        return items;
    }

    public void setItems(List<NewsItem> items) {
        this.items = items;
    }


    public  Channel getChannelByRssUrl (URL rss) {
        Channel channel = null;
        try {

            JAXBContext context = JAXBContextFactory.createContext(new Class[]{Channel.class}, null);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            channel = (Channel) unmarshaller.unmarshal(rss);
            for ( NewsItem item : channel.getItems() ){
                String imagepath = null;
                for ( ElementNSImpl elementNSImpl : item.getElements() ){
                    imagepath =  (imagepath == null || imagepath.equals("") ) ? elementNSImpl.getAttribute("url") : imagepath;
                    if (imagepath !=null && !imagepath.equals("") ){
                        item.setImagePath(imagepath);
                    }
                }
            }
//
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(channel, System.out);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", lastBuildDate='" + lastBuildDate + '\'' +
                '}';
    }
}
