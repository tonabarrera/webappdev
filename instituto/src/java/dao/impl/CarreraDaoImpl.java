/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.CarreraDao;
import dto.Carrera;
import java.sql.PreparedStatement;
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
public class CarreraDaoImpl implements CarreraDao{
    private static final String SQL_SELECT_ALL = "SELECT * FROM carreras";
    private static final String SQL_DELETE = "DELETE FROM carreras where carrera_id=?;";
    private static final String SQL_SELECT = "SELECT * FROM carreras where carrera_id=?";
    private Conexion conexion;

    @Override
    public List<Carrera> readAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion = Conexion.getInstance();
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
           if (rs != null)
                conexion.cerrar(rs);
            if (ps != null)
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

    @Override
    public void delete(Carrera carrera) throws SQLException {
        PreparedStatement ps = null;
        conexion = Conexion.getInstance();
        try {
            ps = conexion.createPreparedStatement(SQL_DELETE);
            ps.setInt(1, carrera.getId());
            ps.executeUpdate();
        } finally {
            if (ps != null)
                conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    @Override
    public Carrera read(Carrera c) throws SQLException  {
       PreparedStatement ps = null;
       ResultSet rs = null;
       conexion = Conexion.getInstance();
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
           if (ps != null)
               conexion.cerrar(ps);
           if (rs != null)
               conexion.cerrar(rs);
           conexion.cerrar();
       }
   }

}
