package net.bash.serg.slownews;

import net.bash.serg.slownews.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by Serg Bash on 12/20/2015.
 */
public class Main {
    public static  void main(String [] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit_demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {

        transaction.begin();

        User user1 = new User("Serg", "1", "basoy1988@mail.ru");
        entityManager.persist(user1);
        transaction.commit();

        } catch (Exception ex){
            System.out.println(ex.getMessage());
            transaction.rollback();
        }
        finally
        {
            entityManager.close();
        }
    }
}