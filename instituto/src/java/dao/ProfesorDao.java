/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.Profesor;
import java.sql.SQLException;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public interface ProfesorDao {
    Profesor findByUsername(String username) throws SQLException;
    Profesor read(Profesor p) throws SQLException;
}
