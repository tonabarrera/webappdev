package me.tonatihu.dao;

import me.tonatihu.entity.UsuarioEntity;

import java.io.Serializable;

/**
 * @author tonatihu
 * Created on 3/17/19
 */

public interface UsuarioDao<T, Id extends Serializable> {
    T findByUsernameAndContra(String username, String contra);
}
