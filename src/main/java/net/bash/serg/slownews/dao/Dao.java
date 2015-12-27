package net.bash.serg.slownews.dao;

import net.bash.serg.slownews.entity.SlowNewsEntity;
import net.bash.serg.slownews.moxy.Moxy;

import java.util.List;

/**
 * Created by Serg Bash on 12/20/2015.
 */
public interface Dao {
    void close();
    void create(Moxy entity);
    void create(SlowNewsEntity entity);
    void update(SlowNewsEntity entity);
    SlowNewsEntity read(Long id);
    SlowNewsEntity getByLogin(String login);
    List <SlowNewsEntity> getAll();
}
