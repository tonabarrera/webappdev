/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonatihu
 */
public class AlumnoDAOImpl implements AlumnoDAO{
    private static final String SQL_INSERT = "insert into alumno(boleta, nombre, ap_paterno, ap_materno, email, carrera_id) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update alumno set boleta=?, nombre=?, ap_paterno=?, ap_materno=?, email=?, carrera_id=? where boleta=?";
    private static final String SQL_SELECT = "select * from alumno where boleta=?";
    private static final String SQL_SELECT_ALL = "select * from alumno";
    private static final String SQL_DELETE = "delete from alumno where boleta=?";
    

    @Override
    public void create(Alumno c) {
    }

    @Override
    public Alumno read(Alumno c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Alumno c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Alumno c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
