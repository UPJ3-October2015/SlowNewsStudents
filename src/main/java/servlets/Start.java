package servlets;

import model.UserBean;
import model.UserList;

import javax.jws.WebService;
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

@WebServlet("/")
public class Start extends Dispatcher {


    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = request.getSession().getServletContext();

        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("signIn").forward(request, response);
        } else {
            request.getRequestDispatcher("news").forward(request, response);
        }
    }
}
