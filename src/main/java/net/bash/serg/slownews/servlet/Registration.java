package net.bash.serg.slownews.servlet;


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
import java.util.List;

/**
 * Created by bso05702 on 16.11.2015.
 */
@WebServlet("/registration")
public class Registration extends HttpServlet{

    private static final String BEGIN = "/WEB-INF/view/index.jsp";
    private static final String REGISTRATION = "/WEB-INF/view/registration.jsp";
    private static final String ERROR = "/WEB-INF/view/error.jsp";

    @Override
    @SuppressWarnings (value="unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getSession(false).invalidate();
        ServletContext context = getServletContext();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        Users user = new Users(login, password, email);
        EntityCreator entityCreator = new EntityCreator();
        List <Users> users = (List <Users>) (Object) entityCreator.viewData("SELECT users FROM Users users where " +
                "login = '" + login + "'");

        if (users.size() != 0) {
                if (users.get(0).getLogin().equals(login)) {
                    context.setAttribute("error", "User with that name already exists!");
                    dispatcherForward(ERROR, req, res);
                }
        }
        else {
            entityCreator.insertData(user);
            context.setAttribute("login", login);
        }
        entityCreator.close();
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