/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Categoria;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 */
public interface CategoriaDao {
    List<Categoria> readAll() throws SQLException;
    Categoria read(Categoria c) throws SQLException ;
    void delete(Categoria c) throws SQLException ;
}
