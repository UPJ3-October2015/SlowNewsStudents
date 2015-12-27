package net.bash.serg.slownews.controller;

import net.bash.serg.slownews.dao.UserDao;
import net.bash.serg.slownews.entity.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final String BEGIN = "/WEB-INF/view/index.jsp";
    private static final String ERROR = "/WEB-INF/view/error.jsp";
    private static final String LOGIN = "/WEB-INF/view/login.jsp";

    @Override
    @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao dao = new UserDao();
        UserEntity user = (UserEntity) dao.getByLogin(login);

        if(user != null) {
            if (user.getLogin().equals(login) &&
                user.getPassword().equals(password)) {
                context.setAttribute("login", login);
                dispatcherForward(BEGIN, req, res);
            }

            else if(!user.getLogin().equals(login) ||
                    !user.getPassword().equals(password)){
                context.setAttribute("error",  "Login and password not match!");
                dispatcherForward(ERROR, req, res);
            }
        }
        else {
            context.setAttribute("error",  "Login " + login + " not registered!");
            dispatcherForward(ERROR, req, res);
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
            dispatcherForward(LOGIN, req, res);
    }

    public void dispatcherForward(String jspName, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        RequestDispatcher dispatcher = application.getRequestDispatcher(jspName);
        dispatcher.forward(req, res);
    }
}
