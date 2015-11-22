package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by voldem on 17.11.2015.
 */
public class Registration extends Dispatcher {
    public String getServletInfo() {
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        if (request.getParameter("checkUser") != null) {
            this.forward("/CheckUser", request, response);
//        } else if (request.getParameter("save")!=null) {
//            this.forward("/registration.jsp", request, response);
        }
    }
}