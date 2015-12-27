package net.bash.serg.slownews.dao;

import net.bash.serg.slownews.entity.NewsEntity;
import net.bash.serg.slownews.entity.SlowNewsEntity;
import net.bash.serg.slownews.moxy.Moxy;
import org.jboss.logging.Logger;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serg Bash on 12/23/2015.
 */
public class UserDao implements Dao{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private EntityTransaction transaction;
    private static final Logger LOGGER = Logger.getLogger(UserDao.class);

    public UserDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit_demo");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    @Override
    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    @Override
    public void create(Moxy news) {
        try{
            transaction.begin();
            entityManager.persist(news);
            transaction.commit();

        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            transaction.rollback();
        }
        finally {
            close();
        }
    }

    @Override
    public void create(SlowNewsEntity news) {
        try{
            transaction.begin();
            entityManager.persist(news);
            transaction.commit();

        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            transaction.rollback();
        }
        finally {
            close();
        }
    }

    @Override
    public NewsEntity read(Long id) {
        return null; // getEntityManager().find(News.class, id);
    }

    @Override
    public void update(SlowNewsEntity news) {
    }


    @Override
    public List<SlowNewsEntity> getAll() {
        List <SlowNewsEntity> results = new ArrayList<>();
        try{
            transaction.begin();
            TypedQuery<SlowNewsEntity> result =
                    entityManager.createQuery("SELECT users FROM Users users", SlowNewsEntity.class);
            transaction.commit();
            results = result.getResultList();

        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            transaction.rollback();
        }
        finally {
            close();
        }
        return results;
    }

    @Override
    public SlowNewsEntity getByLogin(String login) {
        List <SlowNewsEntity> results = new ArrayList<>();
        try{
            transaction.begin();
            TypedQuery <SlowNewsEntity> result =
                    entityManager.createQuery("SELECT users FROM Users users where login = '" + login + "'",
                            SlowNewsEntity.class);
            transaction.commit();
            results = result.getResultList();

        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            transaction.rollback();
        }
        finally {
            close();
        }
        if(!results.isEmpty()) {
            return results.get(0);
        }
        else {
            return null;
        }
    }
}

