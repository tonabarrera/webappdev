package me.tonatihu.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author tonatihu
 * Created on 3/13/19
 */
@Entity
@Table(name = "usuario", schema = "public", catalog = "tiendita")
public class UsuarioEntity implements Serializable {
    @Id
    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Basic
    @Column(name = "contra", nullable = false, length = 20)
    private String contra;

    @Basic
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Basic
    @Column(name = "ap_paterno", nullable = false, length = 30)
    private String apPaterno;

    @Basic
    @Column(name = "ap_materno", nullable = false, length = 30)
    private String apMaterno;

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = username;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "UsuarioEntity{" + "username='" + username + '\'' + ", contra='" + contra + '\'' +
                ", email='" + email + '\'' + ", nombre='" + nombre + '\'' + ", apPaterno='" +
                apPaterno + '\'' + ", apMaterno='" + apMaterno + '\'' + '}';
    }
}
