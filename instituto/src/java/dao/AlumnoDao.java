/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Alumno;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface AlumnoDao {
    Alumno findByUsername(String username) throws SQLException;
}
