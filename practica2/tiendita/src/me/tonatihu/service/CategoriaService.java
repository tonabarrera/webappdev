package me.tonatihu.service;

import me.tonatihu.dao.impl.CategoriaDaoImpl;
import me.tonatihu.entity.CategoriaEntity;

import java.util.List;

/**
 * @author tonatihu
 * Created on 3/13/19
 */

public class CategoriaService {
    private static CategoriaDaoImpl categoriaDao;

    public CategoriaService() {
        categoriaDao = new CategoriaDaoImpl();
    }

    public void persist(CategoriaEntity categoriaEntity) {
        categoriaDao.openCurrentSessionWithTransaction();
        categoriaDao.persist(categoriaEntity);
        categoriaDao.closeCurrentSessionwithTransaction();
    }

    public void update(CategoriaEntity categoriaEntity) {
        categoriaDao.openCurrentSessionWithTransaction();
        categoriaDao.update(categoriaEntity);
        categoriaDao.closeCurrentSessionwithTransaction();
    }

    public CategoriaEntity findById(int id) {
        categoriaDao.openCurrentSession();
        CategoriaEntity categoriaEntity = categoriaDao.findById(id);
        categoriaDao.closeCurrentSession();
        return categoriaEntity;
    }

    public void delete(int id) {
        categoriaDao.openCurrentSessionWithTransaction();
        CategoriaEntity categoriaEntity = categoriaDao.findById(id);
        categoriaDao.delete(categoriaEntity);
        categoriaDao.closeCurrentSessionwithTransaction();
    }

    public List<CategoriaEntity> findAll() {
        categoriaDao.openCurrentSession();
        List<CategoriaEntity> books = categoriaDao.findAll();
        categoriaDao.closeCurrentSession();
        return books;
    }

    public CategoriaDaoImpl categoriaDao() {
        return categoriaDao;
    }
}
