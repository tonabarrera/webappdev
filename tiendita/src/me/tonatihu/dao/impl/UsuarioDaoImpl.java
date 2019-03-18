package me.tonatihu.dao.impl;

import me.tonatihu.dao.GenericDao;
import me.tonatihu.dao.UsuarioDao;
import me.tonatihu.entity.UsuarioEntity;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author tonatihu
 * Created on 3/17/19
 */

public class UsuarioDaoImpl extends GenericDao<UsuarioEntity, String> implements UsuarioDao<UsuarioEntity, String> {
    private static final String FIND_BY_USERNAME_AND_CONTRA = "from UsuarioEntity where username=:u and contra=:p";

    @Override
    public UsuarioEntity findByUsernameAndContra(String username, String contra) {
        openCurrentSession();
        Query query = getCurrentSession().createQuery(FIND_BY_USERNAME_AND_CONTRA);
        query.setParameter("u", username);
        query.setParameter("p", contra);
        UsuarioEntity categoriaEntity = (UsuarioEntity) query.uniqueResult();
        closeCurrentSession();
        return categoriaEntity;
    }

    @Override
    public void create(UsuarioEntity entity) {

    }

    @Override
    public void update(UsuarioEntity entity) {

    }

    @Override
    public UsuarioEntity findById(String s) {
        return null;
    }

    @Override
    public void delete(UsuarioEntity entity) {

    }

    @Override
    public List<UsuarioEntity> findAll() {
        return null;
    }
}
