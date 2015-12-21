package com.infopuls.tash.slownews.dao;

import com.infopuls.tash.slownews.entity.User;

import javax.persistence.*;
import java.util.List;

public class UserDao {

    private static final String PERSISTENT_UNIT_NAME = "item-manager";
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addUser(User u) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
    }

    public User findUserByLogin(String login) {
        try {
            String queryString = "SELECT c FROM User c WHERE c.login = '"+ login+"'";

            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            TypedQuery<User> query = manager.createQuery(queryString, User.class);
            User result = query.getSingleResult();
            manager.getTransaction().commit();
            return  result;
        }catch (NoResultException e)   {
            return null;
        }

    }

    public User  findUserByLoginPassword(String login , String password) {
        try {
            String queryString = "SELECT c FROM User c WHERE c.login = '" + login + "' and c.password = '" + password + "'";

            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            TypedQuery<User> query = manager.createQuery(queryString, User.class);
            User results = query.getSingleResult();
            manager.getTransaction().commit();
            return results;
        }catch (NoResultException e)   {
            return null;
        }

    }



}
