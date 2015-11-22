package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by voldem on 17.11.2015.
 */
public class AddUser extends Dispatcher {
    public String getServletInfo() {
        return "Add user servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();

        if (request.getParameter("confirm").equals(request.getParameter("password"))) {
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            UserBean newUser = new UserBean();
            newUser.setUser(user);
            newUser.setPassword(password);
            newUser.setEmail(email);
            context.setAttribute("user", newUser);
            boolean res = UserList.addUser(newUser);
            if (res) {
                this.forward("/successRegistration.jsp", request, response);
            } else {
                this.forward("/errorRegistration.jsp", request, response);
            }
        } else {
            this.forward("/errorRegistration.jsp", request, response);
        }
    }
}
