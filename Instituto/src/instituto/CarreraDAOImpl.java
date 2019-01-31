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
public class CarreraDAOImpl implements CarreraDAO{
    private static final String SQL_INSERT = "insert into carrera(nombre, descripcion, duracion) values (?, ?, ?)";
    private static final String SQL_UPDATE = "update carrera set nombre=?, descripcion=?, duracion=? where carrera_id=?";
    private static final String SQL_SELECT = "select * from carrera where carrera_id=?";
    private static final String SQL_SELECT_ALL = "select * from carrera";
    private static final String SQL_DELETE = "delete from carrera where carrera_id=?";
    
    Connection con = null;

    @Override
    public void create(Carrera c) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_INSERT);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getDuracion());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(con);
        }
    }

    @Override
    public Carrera read(Carrera c) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT);
            ps.setInt(1, c.getId());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (Carrera) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(con);
        }
    }
    
    @Override
    public List<Carrera> readAll() throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(con);
        }
    }

    @Override
    public void update(Carrera c) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getDuracion());
            ps.setInt(4, c.getId());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(con);
        }
    }

    @Override
    public void delete(Carrera c) throws SQLException {
        PreparedStatement ps = null;
        obtenerConexion();
        try {
            ps = con.prepareStatement(SQL_DELETE);
            ps.setInt(1, c.getId());
            ps.executeUpdate();
        } finally {
            cerrar(ps);
            cerrar(con);
        }
    }
    
    private void obtenerConexion() {
        String user = "root";
        String pwd = "respuesta42";
        String url = "jdbc:mysql://localhost:3306/instituto";
        String mySqlDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(mySqlDriver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void cerrar(PreparedStatement ps) throws SQLException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {}
        }
    }

    private void cerrar(Connection cnn) {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (SQLException e) {}
        }
    }

    private void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {}
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
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
