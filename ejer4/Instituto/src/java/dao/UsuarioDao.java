/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Usuario;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created on 23-Feb-2019
 */
public interface UsuarioDao {
    boolean existsByNombreAndClave(String nombre, String clave) throws SQLException ;
    void create(Usuario usuario) throws SQLException;
    boolean existByNombre(String nombre) throws SQLException;
    Usuario read(String nombre) throws SQLException;
}
