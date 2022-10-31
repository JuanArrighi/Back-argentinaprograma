/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

    private int id;
    private String nombreP;
    private String descripcionP;
    private String inicioP;
    private String finP;
    private String linkP;

    public Project() {
    }

    public Project(String nombreP, String descripcionP, String inicioP, String finP, String linkP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.inicioP = inicioP;
        this.finP = finP;
        this.linkP = linkP;
    }


    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getInicioP() {
        return inicioP;
    }

    public void setInicioP(String inicioP) {
        this.inicioP = inicioP;
    }

    public String getFinP() {
        return finP;
    }

    public void setFinP(String finP) {
        this.finP = finP;
    }

    public String getLinkP() {
        return linkP;
    }

    public void setLinkP(String linkP) {
        this.linkP = linkP;
    }
    
    
    
}
