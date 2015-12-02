package com.infopuls.tash.controllers;

import com.infopuls.tash.user.User;
import com.infopuls.tash.user.UsersMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="RegistrationController", urlPatterns={"/registration"})

public class RegistrationController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = "/registration";
        request.setAttribute("errorText", "");
        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersMap map = UsersMap.getInstance();
        String userPath = null;

        String login = request.getParameter("contact_login");
        String password = request.getParameter("contact_password");
        String confirm_password = request.getParameter("contact_confirm-password");
        String first_name = request.getParameter("contact_first_name");
        String last_name = request.getParameter("contact_last_name");
        String email = request.getParameter("contact_email");
        String phoneNumber = request.getParameter("contact_phoneNumber");
        if (login == null || password == null || confirm_password == null || first_name == null) {
            userPath = "/registration";
            request.setAttribute("errorText", "It is necessary to fill fields");
        } else {

            if (map.isExistLogin(login)) {
                userPath = "/registration";
                request.setAttribute("errorText", "Unfortunately, this username is not available");
            } else {
                User current_user = new User(login, password);
                current_user.setEmail(email);
                current_user.setFirstName(first_name);
                current_user.setLastName(last_name);
                current_user.setPhoneNumber(phoneNumber);

                map.addUser(current_user);
                request.getSession().setAttribute("user" ,current_user );
                userPath = "/news";
            }
        }

        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
