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
public class Usuario {
    private int id;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String email;
    private String username;
    private String password;
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

    public void setNombre(String name) {
        this.nombre = name;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int type) {
        this.tipo = type;
    }
    
    public String getTipoValor() {
        if (tipo == 1)
            return "ALUMNO";
        else
            return "PROFESOR";
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + nombre 
                + ", lastName=" + apPaterno + ", secondLastName=" + apMaterno 
                + ", email=" + email + ", username=" + username 
                + ", password=" + password + ", type=" + tipo + '}';
    }

    public Object getNombreCompleto() {
        return nombre + " " + apPaterno + " " + apMaterno;
    }
    
    
}
