package me.tonatihu.dao.impl;

import me.tonatihu.dao.CategoriaDao;
import me.tonatihu.dao.GenericDao;
import me.tonatihu.dto.Dato;
import me.tonatihu.entity.CategoriaEntity;

import java.util.List;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public class CategoriaDaoImpl extends GenericDao<CategoriaEntity, Integer> implements CategoriaDao{
    @Override
    public void create(CategoriaEntity entity) {
        getCurrentSession().persist(entity);
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
    @SuppressWarnings("unchecked")
    public List<CategoriaEntity> findAll() {
        return (List<CategoriaEntity>) getCurrentSession().createQuery("from CategoriaEntity ").list();
    }
}
