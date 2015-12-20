package net.bash.serg.slownews.servlet;

/*

import net.bash.serg.slownews.model.User;

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
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    private static final String BEGIN = "/WEB-INF/view/index.jsp";
    private static final String ERROR = "/WEB-INF/view/error.jsp";
    private static final String LOGIN = "/WEB-INF/view/login.jsp";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Map <String, User> users = (Map <String, User>) session.getAttribute("users");
        if(users != null) {
            Iterator it = users.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                User user = (User) pair.getValue();
                if(user.getUser().equals(login) &&
                   user.getPassword().equals(password)) {
                    session.setAttribute("login", login);
                    dispatcherForward(BEGIN, req, res);
                }
                if(!user.getUser().equals(login)){
                    session.setAttribute("error",  "Login " + login + " not registered!");
                    dispatcherForward(ERROR, req, res);
                }
                else if(!user.getUser().equals(login) ||
                        !user.getPassword().equals(password)){
                    session.setAttribute("error",  "Login and password not miss!");
                    dispatcherForward(ERROR, req, res);
                }
            }
        }
        else {
            session.setAttribute("error",  "No users reqistered in base! Yet...");
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
*/