/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author tonatihu
 * Created on 23-Feb-2019
 */
public class Usuario {
    private int id;
    private String nombre;
    private String clave;
    private int tipo;

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", clave=" + clave + '}';
    }
    
}
