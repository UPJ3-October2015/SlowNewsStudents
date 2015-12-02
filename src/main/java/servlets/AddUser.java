package servlets;

import model.UserBean;
import model.UserList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUser extends Dispatcher {

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

            boolean res = UserList.addUser(newUser);
            if (res) {
                context.setAttribute("user", newUser);
                this.forward("/signIn", request, response);
            } else {
                this.forward("/WEB-INF/view/errorRegistration.jsp", request, response);
            }
        } else {
            this.forward("/WEB-INF/view/errorRegistration.jsp", request, response);
        }
    }
}
