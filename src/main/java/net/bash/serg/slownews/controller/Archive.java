package net.bash.serg.slownews.controller;

import net.bash.serg.slownews.dao.NewsDao;
import net.bash.serg.slownews.dao.UserDao;
import net.bash.serg.slownews.entity.NewsEntity;
import net.bash.serg.slownews.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bso05702 on 18.11.2015.
 */
@WebServlet("/archive")
public class Archive extends HttpServlet {
    private static final String BEGIN = "/WEB-INF/view/archive.jsp";
    private static final String NEWS = "/WEB-INF/view/news.jsp";

    @SuppressWarnings("unchecked")
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        UserDao userDao = new UserDao();
        UserEntity user = (UserEntity) userDao.getByLogin(application.getAttribute("login").toString());

        if (user != null) {
            NewsDao newsDao = new NewsDao();
            List <NewsEntity> news =  newsDao.getAllByUserid(String.valueOf(user.getId()));

            ArrayList list = new ArrayList();

            for (int i = 0; i < news.size(); i++) {
                Map items = new HashMap();
                items.put("category", news.get(i).getCategory());
                items.put("title", news.get(i).getTitle());
                items.put("description", news.get(i).getDescription());
                items.put("image", news.get(i).getImage());
                items.put("link", news.get(i).getLink());
                list.add(items);
            }
            ServletContext  servletContext = getServletContext();
            servletContext.setAttribute("archiveList", list);
            RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
            dispatcher.forward(req, res);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ServletContext application = getServletContext();
        UserDao checkUser = new UserDao();
        UserEntity user = (UserEntity) checkUser.getByLogin(application.getAttribute("login").toString());

        if(user != null) {
            NewsEntity news = new NewsEntity(user.getId(),
                    req.getParameter("category"),
                    req.getParameter("title"),
                    req.getParameter("description"),
                    req.getParameter("image"),
                    req.getParameter("link"));
            UserDao addUser = new UserDao();
            addUser.create(news);
        }
        RequestDispatcher dispatcher = application.getRequestDispatcher(NEWS);
        dispatcher.forward(req, res);
    }
}