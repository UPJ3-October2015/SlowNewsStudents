package com.infopuls.tash.slownews.controllers;

import com.infopuls.tash.slownews.dao.UserDao;
import com.infopuls.tash.slownews.entity.UserEntity;

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

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null || password != null ) {
            UserEntity current_user = new UserDao().findUserByLoginPassword(login, password);
            if( current_user != null){
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
