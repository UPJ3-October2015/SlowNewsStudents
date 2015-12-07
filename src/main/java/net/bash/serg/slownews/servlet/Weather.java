package net.bash.serg.slownews.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import net.bash.serg.slownews.model.WeatherClientMapper;
import net.bash.serg.slownews.model.WeatherClientParser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Serg Bash on 12/2/2015.
 */
@WebServlet("/weather")
public class Weather extends HttpServlet{
    private static final String BEGIN = "/WEB-INF/view/weather.jsp";
    private static final String WEBRESOURCE =
            "http://api.openweathermap.org/data/2.5/weather?q=Kiev&appid=2de143494c0b295cca9337e1e96b00e0";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        HttpSession session = req.getSession();

        Client client =  Client.create();

        WebResource webResource = client
                .resource(WEBRESOURCE);

        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        WeatherClientParser clientParser = new WeatherClientParser();
        session.setAttribute("result", clientParser.getResult());

        WeatherClientMapper weatherClientMapper = new WeatherClientMapper(output);
        session.setAttribute("speed", weatherClientMapper.getSpeed());
        session.setAttribute("temp", weatherClientMapper.getTemp());

        RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
        dispatcher.forward(req, res);
    }
}
