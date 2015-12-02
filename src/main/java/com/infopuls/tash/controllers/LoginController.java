package com.infopuls.tash.controllers;

import com.infopuls.tash.user.User;
import com.infopuls.tash.user.UsersMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="LoginController", urlPatterns={"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userPath = "/login";
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
        String userPath = null;
        UsersMap map = UsersMap.getInstance();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null || password != null ) {
            if (map.checkPassword(login,password)) {
                User current_user = map.findUserbyLogin(login);
                request.getSession().setAttribute("user" ,current_user );
                userPath = "/news";
            }else{
                userPath = "/login";
                request.setAttribute("errorText" ,"Incorrect login or password" );
            }
        }else {
            userPath = "/login";
        }

        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
