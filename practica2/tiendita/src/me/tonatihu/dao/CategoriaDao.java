package me.tonatihu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public interface CategoriaDao <T, Id extends Serializable>{
    void persist(T entity);
    void update(T entity);
    T findById(Id id);
    void delete(T entity);
    List<T> findAll();
}
