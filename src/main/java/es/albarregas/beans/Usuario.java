/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.DefaultValue;

/**
 *
 * @author gared
 */
@Entity
@Table(name = "usuarios")
//Esto es por la herencia
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    protected int idUsuario;

    @Column(name = "email", length = 60, nullable = false, unique = true)

    protected String email;

    @Column(name = "password", length = 128, nullable = false)
    protected String password;
    @Column(name = "nombre", length = 30)
    protected String nombre;
    @Column(name = "apellidos", length = 60)
    protected String apellidos;

    public enum Rol {
        ADMIN,
        TUTOR,
        ALUMNO
    }
    @Column(name = "rol", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    protected Rol rol;

    @Column(name = "dni", length = 9, unique = true)
    protected String dni;
    @Temporal(TemporalType.DATE)
    protected Date ultimoAcceso;
    //PREGUNTAR SI COLUMNDEGINITION ES CORRECTO
    @Column(name = "avatar", length = 30)
    @DefaultValue("avatar.png")
    protected String avatar;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
