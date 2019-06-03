/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tiendita.util.HibernateUtil;

/**
 *
 * @author tonatihu
 * Created on 02-Jun-2019
 */
public abstract class GenericDAO <T, Id extends Serializable>{
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

