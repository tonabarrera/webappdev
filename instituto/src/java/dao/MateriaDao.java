/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Materia;
import dto.Profesor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface MateriaDao {
    List<Materia> findAllFreeSubjects() throws SQLException;
    List<Materia> findSubjectsByProfessor(Profesor profesor) throws SQLException;
    List<Materia> readAll() throws SQLException;
    void delete(Materia materia) throws SQLException;
}
