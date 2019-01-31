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
public class Carrera implements Serializable{
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;

    public Carrera () {}

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getDuracion() {
        return this.duracion;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append("-").append(nombre).append("-")
        .append(descripcion).append("-").append(duracion).append("\n");

        return sb.toString();
    }
}
