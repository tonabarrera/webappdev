/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 */
public interface CarreraDAO {
    public void create(Carrera c) throws SQLException ;
    public Carrera read(Carrera c) throws SQLException;
    public List<Carrera> readAll() throws SQLException;
    public void update(Carrera c) throws SQLException;
    public void delete(Carrera c) throws SQLException;
}
