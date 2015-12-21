package com.infopuls.tash.slownews.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Process {
    public static void main(String[] args){
        System.out.println("Process run");
        EntityManager manager = getEm();
        manager.getTransaction().begin();

        for (int i = 0; i<=4; i++){
            Cars car = new Cars("number"+i, "mark"+i , "color"+i);
            manager.persist(car);
        }

//
//        TypedQuery<Cars> query =
//                manager.createQuery("SELECT c FROM Cars c WHERE c.color = 'color1'", Cars.class);
//        List<Cars> results = query.getResultList();
//
//        for (Cars car : results){
//            System.out.println(car.toString());
//        }

        manager.getTransaction().commit();
        System.out.println("Process end");
    }

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



}
