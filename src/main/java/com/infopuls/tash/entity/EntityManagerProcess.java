package com.infopuls.tash.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EntityManagerProcess {

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

    public static EntityManager getEm() {
        return emf.createEntityManager();
    }

    public static void addEntity(Object o) {
        EntityManager manager = getEm();
        manager.getTransaction().begin();
        manager.persist(o);
        manager.getTransaction().commit();
    }

    public static List<Object>  findEntity(String formula, Class c) {
        EntityManager manager = getEm();
        manager.getTransaction().begin();
        System.out.println(formula);
        TypedQuery<Object> query = manager.createQuery(formula, c);
        List<Object> results = query.getResultList();
        manager.getTransaction().commit();
        return  results;
    }


}
