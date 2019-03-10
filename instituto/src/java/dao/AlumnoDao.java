/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Alumno;
import dto.Datos;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface AlumnoDao {
    Alumno findByUsername(String username) throws SQLException;
    List<Alumno> readAll() throws SQLException;
    List<Datos> getData() throws SQLException;
}
