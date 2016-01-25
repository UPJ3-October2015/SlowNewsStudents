package com.infopuls.tash.slownews.controllers;

import com.infopuls.tash.slownews.convertor.NewsItemConvertor;
import com.infopuls.tash.slownews.dao.NewsItemDao;
import com.infopuls.tash.slownews.dao.NewsItemsCollectionDao;
import com.infopuls.tash.slownews.entity.NewsItemEntity;
import com.infopuls.tash.slownews.model.NewsItem;
import com.infopuls.tash.slownews.model.NewsItemsCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="NewsController", urlPatterns={"/news"})

public class NewsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = "/news";
        String url = "/WEB-INF" + userPath + ".jsp";

        try {

            List<NewsItem> newsItemList = new NewsItemsCollectionDao().getNewsList();
            request.getSession().setAttribute("newsItemsCollection" , new NewsItemsCollection(newsItemList));

            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("********************** doPost test **********************");
        List<NewsItem> newsItemList = new NewsItemsCollectionDao().getNewsList();
        if (!newsItemList.isEmpty()) {
            NewsItem newsItem = newsItemList.get(0);
            NewsItemEntity newsItemEntity = new NewsItemConvertor().toNewsItemEntity(newsItem);
            new NewsItemDao().addNewsItem(newsItemEntity);
        }
    }

}
