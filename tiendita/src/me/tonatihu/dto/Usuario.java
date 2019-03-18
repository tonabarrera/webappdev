package me.tonatihu.dto;

/**
 * @author tonatihu
 * Created on 3/17/19
 */

public class Usuario {
    private String username;
    private String nombreCompleto;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username='" + username + '\'' + ", nombreCompleto='" + nombreCompleto +
                '\'' + '}';
    }
}
