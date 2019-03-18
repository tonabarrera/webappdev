/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.ProfesorDao;
import dto.Profesor;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Conexion;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public class ProfesorDaoImpl implements ProfesorDao{
    private static final String FIND_BY_USERNAME = "{CALL sp_buscar_profesor_username(?)}";
    private static final String SP_FIND_PROFESSOR = "{CALL sp_buscar_profesor(?)}";
    private Conexion conexion;

    @Override
    public Profesor findByUsername(String username) throws SQLException {
        conexion = Conexion.getInstance();
        ResultSet rs = null;
        CallableStatement cs = null;
        Profesor a = new Profesor();
        try {
            cs = conexion.createCallableStatement(FIND_BY_USERNAME);
            cs.setString(1, username);
            rs = cs.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("usuario_id"));
                a.setTipo(rs.getInt("usuario_tipo"));
                a.setNombre(rs.getString("nombre"));
                a.setApPaterno(rs.getString("ap_paterno"));
                a.setApMaterno(rs.getString("ap_materno"));
                a.setEmail(rs.getString("email"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setNumeroProfesor(rs.getString("profesor_num"));
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

    @Override
    public Profesor read(Profesor p) throws SQLException {
        conexion = Conexion.getInstance();
        ResultSet rs = null;
        CallableStatement cs = null;
        try {
            cs = conexion.createCallableStatement(SP_FIND_PROFESSOR);
            cs.setString(1, p.getNumeroProfesor());
            rs = cs.executeQuery();
            List<Profesor> resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null)
                conexion.cerrar(rs);
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }
    
    private List<Profesor> obtenerResultados(ResultSet rs) throws SQLException {
        List<Profesor> resultados = new ArrayList<>();
        while (rs.next()) {
            Profesor a = new Profesor();
            a.setId(rs.getInt("usuario_id"));
            a.setNombre(rs.getString("nombre"));
            a.setApPaterno(rs.getString("ap_paterno"));
            a.setApMaterno(rs.getString("ap_materno"));
            a.setEmail(rs.getString("email"));
            a.setUsername(rs.getString("username"));
            a.setPassword(rs.getString("password"));
            a.setNumeroProfesor(rs.getString("profesor_num"));
            a.setTipo(rs.getInt("usuario_tipo"));
            resultados.add(a);
        }
        return resultados;
    }

}
