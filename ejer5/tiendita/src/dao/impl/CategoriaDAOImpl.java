/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.GenericDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import tiendita.entity.CategoriaEntity;

/**
 *
 * @author tonatihu
 * Created on 02-Jun-2019
 */
public class CategoriaDAOImpl extends GenericDAO<CategoriaEntity, Integer> {
    private static final Logger LOGGER = Logger
            .getLogger(CategoriaDAOImpl.class.getName());
    @Override
    public void create(CategoriaEntity entity) {
        openCurrentSessionWithTransaction();
        try {
            getCurrentSession().save(entity);
        } catch (HibernateException hehe) {
            LOGGER.log(Level.SEVERE, "Error en create", hehe);
            rollback();
        } finally {
            closeCurrentSessionwithTransaction();
        }
    }

    @Override
    public void update(CategoriaEntity entity) {
        openCurrentSessionWithTransaction();
        try {
            getCurrentSession().update(entity);
        } catch (HibernateException hehe) {
            LOGGER.log(Level.SEVERE, "Error en update", hehe);
            rollback();
        } finally {
            closeCurrentSessionwithTransaction();
        }
    }

    @Override
    public CategoriaEntity findById(Integer integer) {
        openCurrentSession();
        CategoriaEntity categoriaEntity = (CategoriaEntity) getCurrentSession()
                .get(CategoriaEntity.class, integer);
        closeCurrentSession();
        return categoriaEntity;
    }

    @Override
    public void delete(CategoriaEntity entity) {
        openCurrentSessionWithTransaction();
        try {
            getCurrentSession().delete(entity);
        } catch (HibernateException hehe) {
            LOGGER.log(Level.SEVERE, "Error en delete", hehe);
            rollback();
        } finally {
            closeCurrentSessionwithTransaction();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CategoriaEntity> findAll() {
        openCurrentSession();
        List<CategoriaEntity> lista = (List<CategoriaEntity>) getCurrentSession()
                .createQuery("from CategoriaEntity").list();
        closeCurrentSession();
        return lista;
    }
}
