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
import tiendita.entity.ProductoEntity;

/**
 *
 * @author tonatihu
 * Created on 02-Jun-2019
 */
public class ProductoDAOImpl extends GenericDAO<ProductoEntity, Integer> {
    private static final Logger LOGGER = Logger
            .getLogger(ProductoDAOImpl.class.getName());
    @Override
    public void create(ProductoEntity entity) {
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
    public void update(ProductoEntity entity) {
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
    public ProductoEntity findById(Integer integer) {
        openCurrentSession();
        ProductoEntity productoEntity = (ProductoEntity) getCurrentSession()
                .get(ProductoEntity.class, integer);
        closeCurrentSession();
        return productoEntity;
    }

    @Override
    public void delete(ProductoEntity entity) {
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
    public List<ProductoEntity> findAll() {
        openCurrentSession();
        List<ProductoEntity> lista = (List<ProductoEntity>) getCurrentSession()
                .createQuery("from ProductoEntity").list();
        closeCurrentSession();
        return lista;
    }
}
