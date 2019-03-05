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
 */
public class Articulo implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int existencia;
    private Categoria categoria;

    public int getId() {
        return id;
    }

    public void setId(int clave) {
        this.id = clave;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Articulo{" + "clave=" + id + ", nombre=" + nombre 
                + ", descripcion=" + descripcion + ", precio=" + precio 
                + ", existencia=" + existencia + ", categoria=" + categoria + '}';
    }
    
    
}
