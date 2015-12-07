package net.bash.serg.slownews.servlet;

import net.bash.serg.slownews.model.NewsObject;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Serg Bash on 12/7/2015.
 */
@WebServlet("/popupMessage")
public class PopupMessage extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{NewsObject.class}, null);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL xmlURL = new URL("https://news.mail.ru/rss/ukraine/");
            InputStream xml = xmlURL.openStream();
            NewsObject newsObject = (NewsObject) unmarshaller.unmarshal(xml);
            res.setContentType("text/html;charset=UTF-8");
            int size = newsObject.getTitle().size() - 1;
            Random random = new Random();
            int randomNum = random.nextInt((size - 0) + 1) + 0;
            res.getWriter().print(newsObject.getTitle().get(randomNum));
            xml.close();
        }
        catch(JAXBException e){
            System.out.println(e.getMessage());
        }
    }
}
