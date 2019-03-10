/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import dao.MateriaDao;
import dto.Carrera;
import dto.Materia;
import dto.Profesor;
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
public class MateriaDaoImpl implements MateriaDao{
    private static final String SQL_FIND_FREE_SUBJECTS = "SELECT * FROM materias WHERE profesor_num IS NULL;";
    private static final String SQL_FIND_BY_PROFESOR = "SELECT * FROM materias WHERE profesor_num=?;";
    private static final String SQL_READ_ALL = "SELECT * FROM materias;";
    private Conexion conexion;

    public MateriaDaoImpl() {
        conexion = new Conexion();
    }

    @Override
    public List<Materia> findAllFreeSubjects() throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_FIND_FREE_SUBJECTS);
            rs = ps.executeQuery();
            List<Materia> resultados = obtenerResultados(rs);
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

    @Override
    public List<Materia> findSubjectsByProfessor(Profesor profesor) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        conexion.conectar();
        try {
            ps = conexion.createPreparedStatement(SQL_FIND_BY_PROFESOR);
            ps.setString(1, profesor.getNumeroProfesor());
            rs = ps.executeQuery();
            List<Materia> resultados = obtenerResultados(rs);
            return resultados;
        } finally {
           if (rs != null)
                conexion.cerrar(rs);
            if (ps != null)
                conexion.cerrar(ps);
            conexion.cerrar();
        }
    }

    private List<Materia> obtenerResultados(ResultSet rs) throws SQLException {
        List<Materia> resultados = new ArrayList<>();
        while (rs.next()) {
            Materia m = new Materia();
            m.setId(rs.getInt("materia_id"));
            m.setDescripcion(rs.getString("descripcion"));
            m.setNombre(rs.getString("nombre"));
            Carrera carrera = new Carrera();
            carrera.setId(rs.getInt("carrera_id"));
            m.setCarrera(carrera);
            Profesor profesor = new Profesor();
            profesor.setNumeroProfesor(rs.getString("profesor_num"));
            m.setProfesor(profesor);
            resultados.add(m);
        }
        return resultados;
    }

}
