package com.infopuls.tash.slownews.controllers;

import com.infopuls.tash.slownews.model.NewsItem;
import com.infopuls.tash.slownews.model.NewsItemsCollection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="LastNewsController", urlPatterns={"/LastNews"})
public class LastNewsController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<NewsItem> newsItemList = new NewsItemsCollection().getNewsList();
        if (!newsItemList.isEmpty()) {
            response.getWriter().write(newsItemList.get(0).getTitle());
        }
    }
}
