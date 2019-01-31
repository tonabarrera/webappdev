/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.io.Serializable;

/**
 *
 * @author tonatihu
 */
public class Alumno implements Serializable {
    private long noBoleta;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private Carrera carrera;

    public Alumno() {}

    public void setNoBoleta(long noBoleta) {
        this.noBoleta = noBoleta;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public long getNoBoleta() {
        return this.noBoleta;
    }

    public String getApPaterno() {
        return this.apPaterno;
    }

    public String getApMaterno() {
        return this.apMaterno;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public Carrera getCarrera() {
        return this.carrera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(noBoleta).append("-").append(nombre).append("-")
        .append(apPaterno).append("-").append(apMaterno).append("-")
        .append(email).append("-").append(carrera).append("\n");

        return sb.toString();
    }
}
