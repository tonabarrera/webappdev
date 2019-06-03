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
    private static final String FIND_BY_USERNAME = "from UsuarioEntity where username=:u";

    @Override
    public UsuarioEntity findByUsernameAndContra(String username, String contra) {
        openCurrentSession();
        Query query = getCurrentSession().createQuery(FIND_BY_USERNAME_AND_CONTRA);
        query.setParameter("u", username);
        query.setParameter("p", contra);
        UsuarioEntity usuario = (UsuarioEntity) query.uniqueResult();
        closeCurrentSession();
        return usuario;
    }

    @Override
    public UsuarioEntity findByUsername(String username) {
        openCurrentSession();
        Query query = getCurrentSession().createQuery(FIND_BY_USERNAME);
        query.setParameter("u", username);
        UsuarioEntity usuario = (UsuarioEntity) query.uniqueResult();
        closeCurrentSession();
        return usuario;
    }

    @Override
    public void create(UsuarioEntity entity) {

    }

    @Override
    public void update(UsuarioEntity entity) {

    }

    @Override
    public UsuarioEntity findById(String s) {
        openCurrentSession();
        UsuarioEntity usuario = getCurrentSession().get(UsuarioEntity.class, s);
        closeCurrentSession();
        return usuario;
    }

    @Override
    public void delete(UsuarioEntity entity) {

    }

    @Override
    public List<UsuarioEntity> findAll() {
        return null;
    }
}
