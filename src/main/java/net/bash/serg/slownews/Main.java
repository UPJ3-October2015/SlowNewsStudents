package net.bash.serg.slownews;

import net.bash.serg.slownews.model.User;
import net.bash.serg.slownews.persistence.interfaces.SlowNewsEntity;
import net.bash.serg.slownews.persistence.model.News;
import net.bash.serg.slownews.persistence.model.Users;
import net.bash.serg.slownews.persistence.utils.EntityCreator;

import java.util.List;

/**
 * Created by Serg Bash on 12/20/2015.
 */
public class Main {
    public static  void main(String [] args) {

       //Users user1 = new Users("Serg", "1", "basoy1988@mail.ru");
       // News news = new News("test description3", "test category", "test title", "no url", "no link");
        EntityCreator entityCreator = new EntityCreator();
       // entityCreator.insertData(user1);
        List <SlowNewsEntity> newsList = entityCreator.viewData("SELECT news FROM News news");
        List <SlowNewsEntity> usersList = entityCreator.viewData("SELECT users FROM Users users");
        System.out.println(newsList.get(0));
        System.out.println(usersList.get(0));
        entityCreator.close();
    }
}