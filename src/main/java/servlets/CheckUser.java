package servlets;

import model.UserBean;
import model.UserList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by voldem on 17.11.2015.
 */
@WebServlet("/signIn")
public class CheckUser extends Dispatcher {
    public String getServletInfo() {
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserBean user = UserList.findUser(request.getParameter("user"));
        if (user == null) {
            this.forward("/WEB-INF/view/login.jsp", request, response);
        } else {
            if (!user.getPassword().equals(request.getParameter("password"))
                    && !user.getEmail().equals(request.getParameter("email"))
                    && !user.getUser().equals(request.getParameter("user"))) {
                this.forward("/WEB-INF/view/registration.jsp", request, response);
            } else {
                HttpServletRequest httpRequest = (HttpServletRequest) request;
                HttpSession session = httpRequest.getSession();
                session.setAttribute("curUserBean", user);
                this.forward("/WEB-INF/view/successLogin.jsp", request, response);
            }
        }

    }
}
