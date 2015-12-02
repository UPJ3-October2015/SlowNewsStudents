package com.infopuls.tash.controllers;

import com.infopuls.tash.user.User;
import com.infopuls.tash.user.UsersMap;
import com.infopuls.tash.ws.Weather;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet (name="MainController", urlPatterns={"/" , "/logout"})

public class MainController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {

        String userPath = request.getServletPath();
        UsersMap map = UsersMap.getInstance();
        request.getSession().setAttribute("weather" , new Weather().getCurrentWeather() );
        //request.getSession().setAttribute("weather" , new Weather(22.3) );



        if (userPath.equals("/") ) {
                userPath = "/index";
        }else if (userPath.equals("/logout")){
            userPath = "/index";
            request.getSession().setAttribute("user" ,null );
        }

        String url = "/WEB-INF" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
