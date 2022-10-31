/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Portfolio.JiArrighi.Dto;

import javax.validation.constraints.NotBlank;



public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String empresaE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String inicioE;
    @NotBlank
    private String finE;
    private String logoE;
    
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String empresaE, String descripcionE, String inicioE, String finE, String logoE) {
        this.nombreE = nombreE;
        this.empresaE = empresaE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
        this.logoE = logoE;
    }
    
    //Getters and Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getEmpresaE() {
        return empresaE;
    }

    public void setEmpresaE(String empresaE) {
        this.empresaE = empresaE;
    }

    public String getInicioE() {
        return inicioE;
    }

    public void setInicioE(String inicioE) {
        this.inicioE = inicioE;
    }

    public String getFinE() {
        return finE;
    }

    public void setFinE(String finE) {
        this.finE = finE;
    }

    public String getLogoE() {
        return logoE;
    }

    public void setLogoE(String logoE) {
        this.logoE = logoE;
    }
    
    
}
