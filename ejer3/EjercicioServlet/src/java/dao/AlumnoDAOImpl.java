/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import db.Conexion;
import dto.Alumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonatihu
 * Created on 01-Feb-2019
 */
public class AlumnoDAOImpl implements AlumnoDAO{
    private static final String SQL_INSERT = "insert into alumno(boleta, nombre, ap_paterno, ap_materno, email, carrera_id) values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update alumno set nombre=?, ap_paterno=?, ap_materno=?, email=?, carrera_id=? where boleta=?";
    private static final String SQL_SELECT = "select * from alumno where boleta=?";
    private static final String SQL_SELECT_ALL = "select * from alumno";
    private static final String SQL_DELETE = "delete from alumno where boleta=?";

    private Conexion conexion;

    public AlumnoDAOImpl() {
        conexion = new Conexion();
    }

    @Override
    public void create(Alumno a) throws SQLException {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_INSERT);
            ps.setLong(1, a.getNoBoleta());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApPaterno());
            ps.setString(4, a.getApMaterno());
            ps.setString(5, a.getEmail());
            ps.setInt(6, a.getCarrera().getId());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public Alumno read(Alumno a) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_SELECT);
            ps.setLong(1, a.getNoBoleta());
            rs = ps.executeQuery();
            List<Alumno> resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados.get(0);
            } else {
                return null;
            }
        } finally {
            conexion.cerrar(rs);
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    private List<Alumno> obtenerResultados(ResultSet rs) throws SQLException {
        List<Alumno> resultados = new ArrayList<>();
        while (rs.next()) {
            Alumno a = new Alumno();
            a.setNoBoleta(rs.getLong("boleta"));
            a.setNombre(rs.getString("nombre"));
            a.setApPaterno(rs.getString("ap_paterno"));
            a.setApMaterno(rs.getString("ap_materno"));
            a.setEmail(rs.getString("email"));
            resultados.add(a);
        }
        return resultados;
    }

    @Override
    public List readAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List<Alumno> resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            conexion.cerrar(rs);
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public void update(Alumno a) throws SQLException {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_UPDATE);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApPaterno());
            ps.setString(3, a.getApMaterno());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getCarrera().getId());
            ps.setLong(6, a.getNoBoleta());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public void delete(Alumno a) throws SQLException {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_DELETE);
            ps.setLong(1, a.getNoBoleta());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }
}

