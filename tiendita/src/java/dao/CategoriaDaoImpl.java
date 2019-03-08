/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.Conexion;
import dto.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonatihu
 */
public class CategoriaDaoImpl implements CategoriaDao{
    private static final String SQL_SELECT_ALL = "select * from categorias";
    private static final String SQL_FIND_BY_ID = "select * from categorias where categoria_id=?";
    private static final String SQL_DELETE_BY_ID = "delete * from categorias where categoria_id=?";
    private Conexion conexion = new Conexion();

    @Override
    public List readAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List<Categoria> resultados = obtenerResultados(rs);
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

    private List<Categoria> obtenerResultados(ResultSet rs) throws SQLException {
        List<Categoria> resultados = new ArrayList<>();
        while (rs.next()) {
            Categoria c = new Categoria();
            c.setId(rs.getInt("categoria_id"));
            c.setNombre(rs.getString("nombre"));
            c.setDescripcion(rs.getString("descripcion"));
            resultados.add(c);
        }
        return resultados;
    }

    @Override
    public Categoria read(Categoria c) throws SQLException{
         PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_FIND_BY_ID);
            ps.setLong(1, c.getId());
            rs = ps.executeQuery();
            List<Categoria> resultados = obtenerResultados(rs);
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
    public void delete(Categoria c) throws SQLException  {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_DELETE_BY_ID);
            ps.setLong(1, c.getId());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }
    
}
