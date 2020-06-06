package edu.idat.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 150)
    @NotEmpty(message = "El apellido paterno no puede estar vacío")
    private String apellidoPaterno;

    private String apellidoMaterno;

    private String nombres;

    @Min(value = 1900, message = "El año de nacimiento no puede ser menor a 1900")
    private int anioNacimiento;

    private boolean eliminado;

    @OneToMany(mappedBy = "cliente")
    private List<Telefono> telefonos;

    public Cliente() {
        this.id = 0;
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.nombres = "";
        this.anioNacimiento = 0;
        this.eliminado = false;
        this.telefonos = new ArrayList<>();
    }

    public Cliente(int id, String apellidoPaterno, String apellidoMaterno, String nombres, int anioNacimiento) {
        this.id = id;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.anioNacimiento = anioNacimiento;
        this.eliminado = false;
        this.telefonos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}
