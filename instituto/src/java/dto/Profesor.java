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
public class Profesor extends Usuario{
    private String numeroProfesor;

    public String getNumeroProfesor() {
        return numeroProfesor;
    }

    public void setNumeroProfesor(String numeroProfesor) {
        this.numeroProfesor = numeroProfesor;
    }

    @Override
    public String toString() {
        return "Profesor{" + "numeroProfesor=" + numeroProfesor + '}';
    }
    
    
}
