package com.infopuls.tash.slownews.dao;

import com.infopuls.tash.slownews.model.Channel;
import com.infopuls.tash.slownews.model.NewsItem;
import com.sun.org.apache.xerces.internal.dom.ElementNSImpl;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class ChannelDao {

    public Channel getChannelByRssUrl (URL rss) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }
}
