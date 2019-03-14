package me.tonatihu.util;

import java.sql.*;

/**
 * @author tonatihu
 * Created on 3/11/19
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
