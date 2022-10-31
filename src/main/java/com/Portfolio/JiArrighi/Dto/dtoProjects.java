/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProjects {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String inicioP;
    @NotBlank
    private String finP;
    @NotBlank
    private String linkP;

    public dtoProjects() {
    }

    public dtoProjects(String nombreP, String descripcionP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombre) {
        this.nombreP = nombre;
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
