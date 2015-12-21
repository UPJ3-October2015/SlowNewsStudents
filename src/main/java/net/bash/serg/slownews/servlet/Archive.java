package net.bash.serg.slownews.servlet;

import net.bash.serg.slownews.persistence.model.News;
import net.bash.serg.slownews.persistence.model.Users;
import net.bash.serg.slownews.persistence.utils.EntityCreator;

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

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        EntityCreator entityCreator = new EntityCreator();
        List <Users> users = (List<Users>) (Object) entityCreator.viewData
                ("SELECT users FROM Users users where login = '" + application.getAttribute("login") + "'");

        if (users.size() != 0) {
            List <News> news = (List<News>) (Object) entityCreator.viewData
                    ("SELECT news FROM News news where userId = '" + users.get(0).getId() + "'");

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
            entityCreator.close();
            RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
            dispatcher.forward(req, res);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        EntityCreator entityCreator = new EntityCreator();
        List <Users> users = (List <Users>) (Object) entityCreator.viewData
                ("SELECT users FROM Users users where login = '" + application.getAttribute("login") + "'");

        if(users.size() != 0) {
            News news = new News(users.get(0).getId(),
                    (String) application.getAttribute("description"),
                    (String) application.getAttribute("category"),
                    (String) application.getAttribute("title"),
                    (String) application.getAttribute("image"),
                    (String) application.getAttribute("link"));
            entityCreator.insertData(news);
            entityCreator.close();
        }
        RequestDispatcher dispatcher = application.getRequestDispatcher(NEWS);
        dispatcher.forward(req, res);
    }
}