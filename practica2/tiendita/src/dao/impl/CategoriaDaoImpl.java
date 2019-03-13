package dao.impl;

import dao.CategoriaDao;
import dto.Categoria;
import util.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public class CategoriaDaoImpl implements CategoriaDao {
    private static final String SQL_SELECT_ALL = "SELECT * FROM categorias";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM categorias WHERE categoria_id=?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM categorias WHERE categoria_id=?";
    private static final String SQL_UPDATE = "UPDATE categorias SET nombre=?, descripcion=? WHERE categoria_id=?";
    private static final String SQL_INSERT = "INSERT INTO categorias(nombre, descripcion) VALUES(?, ?)";
    private Conexion conexion;

    public CategoriaDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Categoria> readAll() throws SQLException {
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

    @Override
    public Categoria read(Categoria c) throws SQLException {
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
    public void delete(Categoria c) throws SQLException {
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

    @Override
    public void create(Categoria c) throws SQLException {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_INSERT);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.executeUpdate();
        } finally {
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
    public void update(Categoria c) throws SQLException  {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getId());
            ps.executeUpdate();
        } finally {
            conexion.cerrar(ps);
            conexion.cerrar();
        }
    }
}
