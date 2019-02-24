/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import db.Conexion;
import dto.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created on 23-Feb-2019
 */
public class UsuarioDaoImpl implements UsuarioDao{
    private static final String SP_EXISTE = "{call sp_existe_by_nombre_clave(?, ?)}";
    private static final String SP_CREAR = "{call sp_crear_usuario(?, ?, ?)}";
    private static final String SP_EXISTE_NOMBRE = "{call sp_existe_by_nombre(?)}";
    private static final String SP_GET_USUARIO = "{call sp_get_usuario(?)}";
    private Conexion conexion;
    
     public UsuarioDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public boolean existsByNombreAndClave(String nombre, String clave) throws SQLException  {
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        System.out.println(nombre + " " + clave);
        try {
            cs = conexion.createCallableStatement(SP_EXISTE);
            cs.setString(1, nombre);
            cs.setString(2, clave);
            rs = cs.executeQuery();
            while(rs.next()) {
                if (rs.getInt("existe") == 1)
                    return true;
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
    public void create(Usuario usuario) throws SQLException {
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_CREAR);
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getClave());
            cs.setInt(3, usuario.getTipo());
            if(cs.executeUpdate() == 1)
                System.out.println("CHIDO");
            else
                System.out.println("NO CHIDO");
        } finally {
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }

    @Override
    public boolean existByNombre(String nombre) throws SQLException {
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_EXISTE_NOMBRE);
            cs.setString(1, nombre);
            rs = cs.executeQuery();
            while(rs.next()) {
                if (rs.getInt("existe") == 1)
                    return true;
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
    public Usuario read(String nombre) throws SQLException{
        ResultSet rs = null;
        CallableStatement cs = null;
        conexion.conectar();
        try {
            cs = conexion.createCallableStatement(SP_GET_USUARIO);
            cs.setString(1, nombre);
            rs = cs.executeQuery();
            while(rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setClave(rs.getString("clave"));
                return usuario;
            }
            return null;
        } finally {
            if (rs != null)
                conexion.cerrar(rs);
            if (cs != null)
                conexion.cerrar(cs);
            conexion.cerrar();
        }
    }
}
