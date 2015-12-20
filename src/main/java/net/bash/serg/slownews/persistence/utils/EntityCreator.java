package net.bash.serg.slownews.persistence.utils;

import net.bash.serg.slownews.persistence.interfaces.SlowNewsEntity;

import javax.persistence.*;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serg Bash on 12/20/2015.
 */
public class EntityCreator {
    private  EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public EntityCreator() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit_demo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insertData(Object object){
        try{
            transaction.begin();
            entityManager.persist(object);
            transaction.commit();

        } catch (Exception ex){
            System.err.println(ex.getMessage());
            transaction.rollback();
        }
    }

    @SuppressWarnings (value="unchecked")
    public List <SlowNewsEntity> viewData(String query){
        List <SlowNewsEntity> results =
                new ArrayList<SlowNewsEntity>();
        try{
            transaction.begin();
            TypedQuery <Object> result =
                    entityManager.createQuery(query, Object.class);
            transaction.commit();
            results = (List <SlowNewsEntity>)(Object)result.getResultList();

        } catch (Exception ex){
            System.err.println(ex.getMessage());
            transaction.rollback();
        }
        return results;
    }
    public void close(){
            entityManager.close();
    }
}
