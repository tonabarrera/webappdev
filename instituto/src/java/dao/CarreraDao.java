/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Carrera;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface CarreraDao {
    List<Carrera> readAll() throws SQLException;
    void delete(Carrera carrera) throws SQLException;
    Carrera read(Carrera carrera) throws SQLException;
}
