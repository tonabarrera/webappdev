/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Profesor;
import dto.Alumno;
import dto.Usuario;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface UsuarioDao {
    boolean existsByUsernameAndPassord(String username, String password) throws SQLException;
    Usuario findByUsername(String username) throws SQLException;
    void create(Alumno student) throws SQLException;
    void create(Profesor professor) throws SQLException;
    void delete(Usuario usuario) throws SQLException;
}
