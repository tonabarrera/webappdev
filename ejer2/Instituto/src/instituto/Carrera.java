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
public class Carrera implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracion;

    public Carrera() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "dto.Carrera{id=" + id + ", nombre='" + nombre + '\'' + ", descripcion='" +
                descripcion + '\'' + ", duracion=" + duracion + '}';
    }
}
