package net.bash.serg.slownews.servlet;



import net.bash.serg.slownews.model.User;
import net.bash.serg.slownews.persistence.interfaces.SlowNewsEntity;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bso05702 on 16.11.2015.
 */@WebServlet("/registration")
public class Registration extends HttpServlet{

    private static final String BEGIN = "/WEB-INF/view/index.jsp";
    private static final String REGISTRATION = "/WEB-INF/view/registration.jsp";
    private static final String ERROR = "/WEB-INF/view/error.jsp";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getSession(false).invalidate();
        ServletContext context = getServletContext();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Users user = new Users(login, password, email);
        List <SlowNewsEntity> usersList = null;
        EntityCreator entityCreator = new EntityCreator();
        if (context.getAttribute("users") instanceof Users) {
            usersList = entityCreator.viewData("SELECT users FROM Users users");
        }
        if (usersList != null) {
            List <Users> users = (List <Users>) (Object) usersList;
            boolean oldUser = false;
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getLogin().contains(login)) {
                    oldUser = true;
                    context.setAttribute("error", "User with that name already exists!");
                    dispatcherForward(ERROR, req, res);
                }
            }
            if(!oldUser){
                entityCreator.insertData(user);
            }
        }
        else {
            entityCreator.insertData(user);
        }
          dispatcherForward(BEGIN, req, res);
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        dispatcherForward(REGISTRATION, req, res);
    }

    public void dispatcherForward(String jspName, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        RequestDispatcher dispatcher = application.getRequestDispatcher(jspName);
        dispatcher.forward(req, res);
    }
}