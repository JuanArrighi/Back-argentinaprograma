package com.Portfolio.JiArrighi.Dto;

import javax.validation.constraints.NotBlank;

public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    private String banner;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String titulo, String descripcion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
    
}
