package me.tonatihu.dto;

/**
 * @author tonatihu
 * Created on 3/24/19
 */

public class Dato {
    private String nombre;
    private int cantidad;

    public Dato(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
