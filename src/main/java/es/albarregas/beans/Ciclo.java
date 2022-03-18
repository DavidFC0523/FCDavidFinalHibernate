/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
/**
 *
 * @author gared
 */
@Entity
@Table(name = "ciclos")
public class Ciclo implements Serializable {

    @Id
    @Column(name = "idCiclo", length = 7, nullable = false)
    private String idCiclo;
    @Column(name = "abreviatura", length = 4, nullable = false)
    private String abreviatura;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ciclosmodulos",
            joinColumns = @JoinColumn(name = "idCiclo"),
            foreignKey = @ForeignKey(name = "FK_ciclosmodulos_ciclos"),
            inverseJoinColumns = @JoinColumn(name = "idModulo"),
            inverseForeignKey = @ForeignKey(name = "FK_ciclosmodulos_modulos"))
    private Set<Modulo> modulos;

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
}