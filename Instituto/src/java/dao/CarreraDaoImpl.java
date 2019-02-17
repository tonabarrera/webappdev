/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import db.Conexion;
import dto.Carrera;
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
public class CarreraDaoImpl implements CarreraDao{
    private static final String SQL_INSERT = "insert into carrera(nombre, descripcion, duracion) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update carrera set nombre=?, descripcion=?, duracion=? where carrera_id=?";
    private static final String SQL_SELECT = "select * from carrera where carrera_id=?";
    private static final String SQL_SELECT_ALL = "select * from carrera";
    private static final String SQL_DELETE = "delete from carrera where carrera_id=?";

    private Conexion conexion;

    public CarreraDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public void create(Carrera c) throws SQLException  {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_INSERT);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getDuracion());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public Carrera read(Carrera c) throws SQLException  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_SELECT);
            ps.setInt(1, c.getId());
            rs = ps.executeQuery();
            List<Carrera> resultados = obtenerResultados(rs);
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

    @Override
    public List readAll() throws SQLException  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List<Carrera> resultados = obtenerResultados(rs);
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
    public void update(Carrera c) throws SQLException  {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getDuracion());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public void delete(Carrera c) throws SQLException  {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_DELETE);
            ps.setInt(1, c.getId());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }


    private List<Carrera> obtenerResultados(ResultSet rs) throws SQLException {
        List<Carrera> resultados = new ArrayList<>();
        while (rs.next()) {
            Carrera c = new Carrera();
            c.setId(rs.getInt("carrera_id"));
            c.setNombre(rs.getString("nombre"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setDuracion(rs.getInt("duracion"));
            resultados.add(c);
        }
        return resultados;
    }
}
