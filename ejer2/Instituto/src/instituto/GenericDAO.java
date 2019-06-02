/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package instituto;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tonatihu
 * Created on 01-Jun-2019
 */
public abstract class GenericDAO <T>{
    public abstract void create(T entity) throws SQLException;
    public abstract void update(T entity) throws SQLException;
    public abstract T read(T entity) throws SQLException;
    public abstract void delete(T entity) throws SQLException;
    public abstract List<T> readAll() throws SQLException;

}
