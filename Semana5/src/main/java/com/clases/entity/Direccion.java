package com.clases.entity;

public class Direccion {
    private int id;
    private String urbanizacion;
    private String calle;
    private int numero;

    public Direccion() {
    }

    public Direccion(int id, String urbanizacion, String calle, int numero) {
        this.id = id;
        this.urbanizacion = urbanizacion;
        this.calle = calle;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrbanizacion() {
        return urbanizacion;
    }

    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
