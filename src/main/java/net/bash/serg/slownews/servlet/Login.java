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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        EntityCreator entityCreator = new EntityCreator();
        List <Users> users = (List <Users>) (Object) entityCreator.viewData("SELECT users FROM Users users where " +
                "login = '" + login + "'");

        if(users.size() != 0) {
            if (users.get(0).getLogin().equals(login) &&
                users.get(0).getPassword().equals(password)) {
                context.setAttribute("login", login);
                dispatcherForward(BEGIN, req, res);
            }

            else if(!users.get(0).getLogin().equals(login) ||
                    !users.get(0).getPassword().equals(password)){
                context.setAttribute("error",  "Login and password not match!");
                dispatcherForward(ERROR, req, res);
            }
        }
        else {
            context.setAttribute("error",  "Login " + login + " not registered!");
            dispatcherForward(ERROR, req, res);
        }
        entityCreator.close();
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
