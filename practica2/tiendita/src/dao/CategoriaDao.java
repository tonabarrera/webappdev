package dao;

import dto.Categoria;

import java.sql.SQLException;
import java.util.List;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public interface CategoriaDao {
    List<Categoria> readAll() throws SQLException;
    Categoria read(Categoria c) throws SQLException;
    void delete(Categoria c) throws SQLException;
    void create(Categoria c) throws SQLException;
    public void update(Categoria c) throws SQLException;
}
