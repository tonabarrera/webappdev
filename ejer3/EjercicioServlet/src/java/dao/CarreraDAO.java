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
 * Created on 01-Feb-2019
 */
public interface CarreraDAO {
    void create(Carrera c) throws SQLException;
    Carrera read(Carrera c) throws SQLException;
    List readAll() throws SQLException;
    void update(Carrera c) throws SQLException;
    void delete(Carrera c) throws SQLException;
}
