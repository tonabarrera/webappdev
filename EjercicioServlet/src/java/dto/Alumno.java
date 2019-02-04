/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.io.Serializable;

/**
 *
 * @author tonatihu
 * Created on 01-Feb-2019
 */
public class Alumno implements Serializable {
    private long noBoleta;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private Carrera carrera;

    public Alumno() {
    }

    public long getNoBoleta() {
        return noBoleta;
    }

    public void setNoBoleta(long noBoleta) {
        this.noBoleta = noBoleta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "dto.Alumno{" + "noBoleta=" + noBoleta + ", nombre='" + nombre + '\'' + ", apPaterno" +
                "='" + apPaterno + '\'' + ", apMaterno='" + apMaterno + '\'' + ", email='" + email + '\'' + ", carrera=" + carrera + '}';
    }
}
