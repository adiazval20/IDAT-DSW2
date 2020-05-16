package com.clases.entity;

public class PersonaDireccion {
    private int id;
    private String nombreCompleto;
    private String direccion;

    public PersonaDireccion() {
    }

    public PersonaDireccion(int id, String nombreCompleto, String direccion) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
