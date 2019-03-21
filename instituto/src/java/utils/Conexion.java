/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public class Conexion {
    private volatile static Conexion instance;
    private Connection connection = null;
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());

    private Conexion() {
        String user = "root";
        String pwd = "respuesta42";
        String dbName = "instituto";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        String mySqlDriver = "com.mysql.jdbc.Driver";
        try {
            Class.forName(mySqlDriver);
            this.connection = DriverManager.getConnection(url, user, pwd);
            LOGGER.log(Level.INFO, "Abriendo Conexion");
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.log(Level.SEVERE, "Error en conectar", e);
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public static Conexion getInstance() throws SQLException {
        if (instance == null || instance.connection.isClosed()) {
            synchronized (Conexion.class) {
                if (instance == null || instance.connection.isClosed())
                    instance = new Conexion();
            } 
        }
        return instance;
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
            } catch (SQLException ignored) {
                LOGGER.log(Level.SEVERE, "Error en cerrar PreparedStatement", ignored);
            }
        }
    }
    
    public void cerrar(CallableStatement cs) {
        if (cs != null) {
            try {
                cs.close();
            } catch (SQLException ignored) {
                LOGGER.log(Level.SEVERE, "Error en cerrar CallableStatement", ignored);
            }
        }
    }
    
    public void cerrar() {
        if (connection != null) {
            try {
                connection.close();
                LOGGER.log(Level.INFO, "Cerrando conexion");
            } catch (SQLException ignored) {
                LOGGER.log(Level.SEVERE, "Error en cerrar", ignored);
            }
        }
    }

    public void cerrar(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ignored) {
                LOGGER.log(Level.SEVERE, "Error en cerrar ResultSet", ignored);
            }
        }
    }
}
