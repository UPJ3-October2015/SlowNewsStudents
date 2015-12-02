package net.bash.serg.slownews.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by bso05702 on 18.11.2015.
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final String BEGIN = "/WEB-INF/view/index.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getSession(false).invalidate();
        ServletContext application = getServletContext();
        HttpSession session = req.getSession();
        session.setAttribute("login", "");
        RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
        dispatcher.forward(req, res);
    }
}
