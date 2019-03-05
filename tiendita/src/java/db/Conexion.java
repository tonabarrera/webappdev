/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created at 21-Feb-2019
 */
public class Conexion {
    private Connection connection = null;

    public void conectar() {
        String user = "postgres";
        String pwd = "postgres";
        String url = "jdbc:postgresql://localhost:5432/tiendita";
        //String driver = "com.mysql.jdbc.Driver";
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement createPreparedStatement(String sqlQuery) throws SQLException {
        return connection.prepareStatement(sqlQuery);
    }
    
    public CallableStatement createCallableStatement(String sqlQuery) throws SQLException {
        return connection.prepareCall(sqlQuery);
    }

    public void cerrar(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ignored) {}
        }
    }
    
    public void cerrar(CallableStatement cs) {
        if (cs != null) {
            try {
                cs.close();
            } catch (SQLException ignored) {}
        }
    }

    public void cerrar() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ignored) {}
        }
    }

    public void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ignored) {}
        }
    }
}

