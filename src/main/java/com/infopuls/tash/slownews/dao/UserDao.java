package com.infopuls.tash.slownews.dao;

import com.infopuls.tash.slownews.entity.UserEntity;

import javax.persistence.*;

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

    public void addUser(UserEntity u) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
    }

    public UserEntity findUserByLogin(String login) {
        try {
            String queryString = "SELECT c FROM UserEntity c WHERE c.login = '"+ login+"'";

            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            TypedQuery<UserEntity> query = manager.createQuery(queryString, UserEntity.class);
            UserEntity result = query.getSingleResult();
            manager.getTransaction().commit();
            return  result;
        }catch (NoResultException e)   {
            return null;
        }

    }

    public UserEntity findUserByLoginPassword(String login , String password) {
        try {
            String queryString = "SELECT c FROM UserEntity c WHERE c.login = '" + login + "' and c.password = '" + password + "'";

            EntityManager manager = emf.createEntityManager();
            manager.getTransaction().begin();

            TypedQuery<UserEntity> query = manager.createQuery(queryString, UserEntity.class);
            UserEntity results = query.getSingleResult();
            manager.getTransaction().commit();
            return results;
        }catch (NoResultException e)   {
            return null;
        }

    }



}
