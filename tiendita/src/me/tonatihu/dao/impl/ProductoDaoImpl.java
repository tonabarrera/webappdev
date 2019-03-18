package me.tonatihu.dao.impl;

import me.tonatihu.dao.GenericDao;
import me.tonatihu.dao.ProductoDao;
import me.tonatihu.entity.ProductoEntity;
import org.hibernate.HibernateException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author tonatihu
 * Created on 3/11/19
 */

public class ProductoDaoImpl extends GenericDao<ProductoEntity, Integer>
        implements ProductoDao<ProductoEntity, Integer> {
    private static final Logger LOGGER = Logger.getLogger(ProductoDaoImpl.class.getName());
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
        ProductoEntity productoEntity = getCurrentSession().get(ProductoEntity.class, integer);
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
