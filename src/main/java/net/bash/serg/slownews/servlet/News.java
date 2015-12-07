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

/**
 * Created by bso05702 on 18.11.2015.
 */
@WebServlet("/news")
public class News extends HttpServlet{
    private static final String BEGIN = "/WEB-INF/view/news.jsp";
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        ServletContext application = getServletContext();
        RequestDispatcher dispatcher = application.getRequestDispatcher(BEGIN);
        try {
            JAXBContext context = JAXBContextFactory.createContext(new Class[]{NewsObject.class}, null);

            Unmarshaller unmarshaller = context.createUnmarshaller();
            URL xmlURL = new URL("https://news.mail.ru/rss/ukraine/");
            InputStream xml = xmlURL.openStream();

            NewsObject newsObject = (NewsObject) unmarshaller.unmarshal(xml);

            ArrayList list = new ArrayList();
            for(int i = 0; i < newsObject.getImage().size(); i++) {
                Map items = new HashMap();
                items.put("category", newsObject.getCategory().get(i));
                items.put("title", newsObject.getTitle().get(i));
                items.put("description", newsObject.getDescription().get(i));
                items.put("image", newsObject.getImage().get(i));
                items.put("link", newsObject.getLink().get(i));
                list.add(items);
            }
             xml.close();
            ServletContext  servletContext = getServletContext();
            servletContext.setAttribute("list", list);
        }
        catch(JAXBException e){
             System.out.println(e.getMessage());
        }
        dispatcher.forward(req, res);
    }
}