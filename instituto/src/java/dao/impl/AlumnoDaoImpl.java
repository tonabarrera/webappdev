/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.AlumnoDao;
import dto.Alumno;
import dto.Carrera;
import dto.Datos;
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
public class AlumnoDaoImpl implements AlumnoDao{
    private static final String FIND_BY_USERNAME = "{CALL sp_buscar_alumno_username(?)}";
    private static final String SP_SELECT_ALL = "{CALL sp_buscar_alumnos()}";
    private static final String SP_GET_COUNT = "{CALL sp_get_data}";

    private final Conexion conexion;

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

    @Override
    public List<Alumno> readAll() throws SQLException {
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_SELECT_ALL);
            rs = cs.executeQuery();
            List<Alumno> resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (cs != null)
                conexion.cerrar(cs);
            if (rs != null)
                conexion.cerrar(rs);
            conexion.cerrar();
        }
    }

    private List<Alumno> obtenerResultados(ResultSet rs) throws SQLException {
        List<Alumno> resultados = new ArrayList<>();
        while (rs.next()) {
            Alumno a = new Alumno();
            a.setNombre(rs.getString("nombre"));
            a.setApPaterno(rs.getString("ap_paterno"));
            a.setApMaterno(rs.getString("ap_materno"));
            a.setEmail(rs.getString("email"));
            a.setUsername(rs.getString("username"));
            a.setPassword(rs.getString("password"));
            a.setBoleta(rs.getString("boleta"));
            a.setType(rs.getInt("usuario_tipo"));
            a.setId(rs.getInt("usuario_id"));
            Carrera c = new Carrera();
            c.setId(rs.getInt("carrera_id"));
            a.setCarrera(c);
            resultados.add(a);
        }
        return resultados;
    }
    
    @Override
    public List getData() throws SQLException {
        ResultSet rs = null;
        CallableStatement cs = null;
        List lista = new ArrayList();
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_GET_COUNT);
            rs = cs.executeQuery();
            while (rs.next()) {
                Datos datos = new Datos();
                datos.setCantidad(Integer.parseInt(rs.getString("alumnos")));
                datos.setNombre(rs.getString("carrera"));
                lista.add(datos);
            }
        } finally {
            if (rs != null)
                conexion.cerrar(rs);
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
        return lista;
    }

}
