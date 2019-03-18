package me.tonatihu.dao;

import me.tonatihu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * @author tonatihu
 * Created on 3/17/19
 */

public abstract class GenericDao <T, Id extends Serializable>{
    private Session currentSession;
    private Transaction currentTransaction;

    public void openCurrentSession() {
        currentSession = HibernateUtil.getSession();
    }

    public void openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public void rollback() {
        if (currentTransaction != null)
            currentTransaction.rollback();
    }

    protected Session getCurrentSession() {
        return currentSession;
    }

    public abstract void create(T entity);
    public abstract void update(T entity);
    public abstract T findById(Id id);
    public abstract void delete(T entity);
    public abstract List<T> findAll();
}
