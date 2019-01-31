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
public interface AlumnoDAO {
    void create(Alumno c) throws SQLException;
    Alumno read(Alumno c) throws SQLException;
    List readAll() throws SQLException;
    void update(Alumno c) throws SQLException;
    void delete(Alumno c) throws SQLException;
}

