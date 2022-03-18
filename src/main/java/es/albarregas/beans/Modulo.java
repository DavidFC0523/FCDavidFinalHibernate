/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author gared
 */
@Entity
@Table(name = "modulos")
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModulo")
    private int idModulo;
    @Column(name = "abreviatura", length = 5, nullable = false)
    private String abreviatura;
    @Column(name = "curso", length = 1, nullable = false)
    private String curso;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Familia")
    private Familia familia;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "horas")
    private short horas;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "modulos")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Ciclo> ciclos;

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getHoras() {
        return horas;
    }

    public void setHoras(short horas) {
        this.horas = horas;
    }

    public Set<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

}
