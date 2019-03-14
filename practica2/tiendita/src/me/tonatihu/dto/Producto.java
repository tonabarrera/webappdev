package me.tonatihu.dto;

/**
 * @author tonatihu
 * Created on 3/11/19
 */

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int existencia;
    private Categoria categoria;

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
        return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", descripcion='" +
                descripcion + '\'' + ", precio=" + precio + ", existencia=" + existencia +
                ", categoria=" + categoria + '}';
    }
}
