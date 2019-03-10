/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author tonatihu
 * Created on 09-Mar-2019
 */
public class Alumno extends Usuario{
    private String boleta;
    private Carrera carrera;

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String studentNum) {
        this.boleta = studentNum;
    }   
}
