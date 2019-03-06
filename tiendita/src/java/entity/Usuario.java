/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tonatihu
 * Created on 05-Mar-2019
 */
@Entity
@Table
public class Usuario implements Serializable{
    @Id
    private int id;
    @Column
    private String username;
    @Column
    private String clave;
    @Column
    private String email;
    @Column
    private String nombre;
    @Column
    private String apPaterno;
    @Column
    private String apMaterno;
}
