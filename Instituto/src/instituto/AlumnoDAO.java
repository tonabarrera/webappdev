/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

/**
 *
 * @author tonatihu
 */
public interface AlumnoDAO {
    public void create(Alumno c);
    public Alumno read(Alumno c);
    public void update(Alumno c);
    public void delete(Alumno c);
}
