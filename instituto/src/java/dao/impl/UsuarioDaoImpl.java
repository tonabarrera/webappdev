/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.UsuarioDao;
import dto.Profesor;
import dto.Alumno;
import dto.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.Conexion;

/**
 *
 * @author tonatihus Created on 09-Mar-2019
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private static final String SP_EXIST_BY_USERNAME_PASSWORD = "{call sp_exists_by_username_password(?, ?)}";
    private static final String SP_CREATE = "{call sp_crear_usuario(?, ?, ?, ?, ?, ?, ?, ?)}";
    private static final String SQL_FIND_BY_USERNAME = "SELECT * FROM usuarios WHERE username=?;";
    private static final String SQL_DELETE = "DELETE FROM usuarios where usuario_id=?;";
    private final Conexion conexion;

    public UsuarioDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public boolean existsByUsernameAndPassord(String username, String password) throws SQLException {
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_EXIST_BY_USERNAME_PASSWORD);
            cs.setString(1, username);
            cs.setString(2, password);
            rs = cs.executeQuery();
            while (rs.next()) {
                if (rs.getInt("existe") == 1) {
                    return true;
                }
            }
            return false;
        } finally {
            if (rs != null)
                conexion.cerrar(rs);
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }

    @Override
    public void create(Alumno student) throws SQLException {
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_CREATE);
            cs.setString(1, student.getNombre());
            cs.setString(2, student.getApPaterno());
            cs.setString(3, student.getApMaterno());
            cs.setString(4, student.getEmail());
            cs.setString(5, student.getUsername());
            cs.setString(6, student.getPassword());
            cs.setInt(7, student.getType());
            cs.setString(8, student.getBoleta());
            cs.executeUpdate();
        } finally {
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }

    @Override
    public void create(Profesor professor) throws SQLException {
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_CREATE);
            cs.setString(1, professor.getNombre());
            cs.setString(2, professor.getApPaterno());
            cs.setString(3, professor.getApMaterno());
            cs.setString(4, professor.getEmail());
            cs.setString(5, professor.getUsername());
            cs.setString(6, professor.getPassword());
            cs.setInt(7, professor.getType());
            cs.setString(8, professor.getNumeroProfesor());
            cs.executeUpdate();
        } finally {
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }

    @Override
    public Usuario findByUsername(String username) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_FIND_BY_USERNAME);
            ps.setString(1, username);
            
            rs = ps.executeQuery();
            List<Usuario> resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados.get(0);
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

    private List<Usuario> obtenerResultados(ResultSet rs) throws SQLException{
        List<Usuario> resultados = new ArrayList<>();
        while (rs.next()) {
            Usuario a = new Usuario();
            a.setId(rs.getInt("usuario_id"));
            a.setNombre(rs.getString("nombre"));
            a.setApPaterno(rs.getString("ap_paterno"));
            a.setApMaterno(rs.getString("ap_materno"));
            a.setEmail(rs.getString("email"));
            a.setUsername(rs.getString("username"));
            a.setPassword(rs.getString("password"));
            a.setType(rs.getInt("usuario_tipo"));
            resultados.add(a);
        }
        return resultados;
    }

    @Override
    public void delete(Usuario usuario) throws SQLException {
        PreparedStatement ps = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_DELETE);
            ps.setInt(1, usuario.getId());
            ps.executeUpdate();
        } finally {
            if (ps != null)
                conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

}
