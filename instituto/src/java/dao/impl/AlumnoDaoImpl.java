/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.AlumnoDao;
import dto.Alumno;
import dto.Carrera;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.Conexion;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public class AlumnoDaoImpl implements AlumnoDao{
    private static final String FIND_BY_USERNAME = "{CALL sp_buscar_alumno_username(?)}";
    
    private Conexion conexion;

    public AlumnoDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public Alumno findByUsername(String username) throws SQLException{
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        Alumno a = new Alumno();
        try {
            cs = conexion.createCallableStatement(FIND_BY_USERNAME);
            cs.setString(1, username);
            rs = cs.executeQuery();
            while (rs.next()) {
                a.setNombre(rs.getString("nombre"));
                a.setApPaterno(rs.getString("ap_paterno"));
                a.setApMaterno(rs.getString("ap_materno"));
                a.setEmail(rs.getString("email"));
                a.setUsername(rs.getString("username"));
                a.setBoleta(rs.getString("boleta"));
                Carrera c = new Carrera();
                c.setId(rs.getInt("carrera_id"));
                a.setCarrera(c);
            }
        } finally {
            if (rs != null)
                conexion.cerrar(rs);
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
        return a;
    }

}
