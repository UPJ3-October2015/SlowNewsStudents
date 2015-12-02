package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by voldem on 17.11.2015.
 */
public class Logout extends Dispatcher {
    public String getServletInfo() {
        return "Logout user";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        session.invalidate();
        this.forward("/WEB-INF/view/registration.jsp", request, response);


    }


}