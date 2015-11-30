package com.slownews.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.slownews.model.BBCXpathMap;
import com.slownews.model.StackOverflowXPathMap;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.ws.rs.client.ClientBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 25.11.2015.
 */
public class Task {
    public static void main(String[] args) throws JAXBException, IOException {
        String responseEntity = ClientBuilder.newClient()
                .target("http://stackoverflow.com/feeds").path("")
                .request().get(String.class);


      //  System.out.println(responseEntity);


        /*JAXBContext context = JAXBContext.newInstance(StackOverflowXPathMap.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StackOverflowXPathMap stackOverflowXPathMap = (StackOverflowXPathMap) unmarshaller.unmarshal(new StringReader("<?xml..."));*/

        //JAXBContext jc = JAXBContext.newInstance(BBCXpathMap.class);
        JAXBContext context = JAXBContextFactory.createContext(new Class[]{BBCXpathMap.class}, null);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        //URL xmlURL = new URL("http://stackoverflow.com/feeds");
        URL xmlURL = new URL("http://feeds.bbci.co.uk/news/technology/rss.xml");

        URLConnection conn = xmlURL.openConnection();
        conn.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
        conn.connect();

        InputStream xml = xmlURL.openStream();
        BBCXpathMap bbcXpathMap = (BBCXpathMap) unmarshaller.unmarshal(xml);

        /* System.out.println(bbcXpathMap.getTitle());
        System.out.println(bbcXpathMap.getDescription());
        System.out.println(bbcXpathMap.getLink());*/

        List titles = new ArrayList<String>();
        titles = bbcXpathMap.getTitles();
        System.out.println(titles.get(3));

        /*System.out.println(bbcXpathMap.getTitles().get(1));
        System.out.println(bbcXpathMap.getDescriptions().get(1));
        System.out.println(bbcXpathMap.getLinks().get(1));*/


        xml.close();

       /* Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bbcXpathMap, System.out);*/


    }
}
