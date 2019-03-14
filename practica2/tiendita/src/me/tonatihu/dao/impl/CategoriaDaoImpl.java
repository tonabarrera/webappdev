package me.tonatihu.dao.impl;

import me.tonatihu.HibernateUtil;
import me.tonatihu.dao.CategoriaDao;
import me.tonatihu.entity.CategoriaEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public class CategoriaDaoImpl implements CategoriaDao<CategoriaEntity, Integer> {
    private Session currentSession;
    private Transaction currentTransaction;

    @Override
    public void persist(CategoriaEntity entity) {
        getCurrentSession().save(entity);
    }

    @Override
    public void update(CategoriaEntity entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public CategoriaEntity findById(Integer id) {
        return getCurrentSession().get(CategoriaEntity.class, id);
    }

    @Override
    public void delete(CategoriaEntity entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<CategoriaEntity> findAll() {
        return (List<CategoriaEntity>) getCurrentSession()
                .createQuery("from CategoriaEntity ").list();
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }



}
