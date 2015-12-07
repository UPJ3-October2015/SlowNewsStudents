package net.bash.serg.slownews.servlet;



import net.bash.serg.slownews.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bso05702 on 16.11.2015.
 */@WebServlet("/registration")
public class
        Registration extends HttpServlet{

    private static final String BEGIN = "/WEB-INF/view/index.jsp";
    private static final String REGISTRATION = "/WEB-INF/view/registration.jsp";
    private static final String ERROR = "/WEB-INF/view/error.jsp";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getSession(false).invalidate();
        ServletContext context = getServletContext();
        String uniqueId = req.getRequestedSessionId();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User(login, password, email);
        Map <String, User> users = null;
        if (context.getAttribute("users") instanceof Map) {
            users = (Map <String, User> ) context.getAttribute("users");
        }
        if (users != null) {
            if (!users.containsValue(user)) {
                users.put(uniqueId, user);
            }
            else{
                context.setAttribute("error", "User with that name already exists!");
                dispatcherForward(ERROR, req, res);
            }
        }
        else {
            users = new HashMap<String, User>();
            users.put(uniqueId, user);
        }
          context.setAttribute("users", users);
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