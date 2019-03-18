package me.tonatihu.service;

import me.tonatihu.dao.impl.CategoriaDaoImpl;
import me.tonatihu.entity.CategoriaEntity;
import org.hibernate.HibernateException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author tonatihu
 * Created on 3/13/19
 */

public class CategoriaService {
    private static final Logger LOGGER = Logger.getLogger(CategoriaService.class.getName());
    private static CategoriaDaoImpl categoriaDao;

    public CategoriaService() {
        categoriaDao = new CategoriaDaoImpl();
    }

    public void create(CategoriaEntity categoriaEntity) {
        try {
            categoriaDao.openCurrentSessionWithTransaction();
            categoriaDao.create(categoriaEntity);
        } catch (HibernateException he) {
            LOGGER.log(Level.WARNING, "Error en create", he);
            categoriaDao().rollback();
        } finally {
            categoriaDao.closeCurrentSessionwithTransaction();
        }
    }

    public void update(CategoriaEntity categoriaEntity) {
        try {
            categoriaDao.openCurrentSessionWithTransaction();
            categoriaDao.update(categoriaEntity);
        } catch (HibernateException he) {
            LOGGER.log(Level.WARNING, "Error en update", he);
            categoriaDao().rollback();
        } finally {
            categoriaDao.closeCurrentSessionwithTransaction();
        }
    }

    public CategoriaEntity findById(int id) {
        categoriaDao.openCurrentSession();
        CategoriaEntity categoriaEntity = categoriaDao.findById(id);
        categoriaDao.closeCurrentSession();
        return categoriaEntity;
    }

    public void delete(int id) {
        try {
            categoriaDao.openCurrentSessionWithTransaction();
            CategoriaEntity categoriaEntity = categoriaDao.findById(id);
            categoriaDao.delete(categoriaEntity);
        } catch (HibernateException he) {
            LOGGER.log(Level.WARNING, "Error en create", he);
            categoriaDao().rollback();
        } finally {
            categoriaDao.closeCurrentSessionwithTransaction();
        }
    }

    public List<CategoriaEntity> findAll() {
        categoriaDao.openCurrentSession();
        List<CategoriaEntity> books = categoriaDao.findAll();
        categoriaDao.closeCurrentSession();
        return books;
    }

    private CategoriaDaoImpl categoriaDao() {
        return categoriaDao;
    }
}
