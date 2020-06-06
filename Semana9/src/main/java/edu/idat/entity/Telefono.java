package edu.idat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "No se puede guardar un teléfono sin número")
    @Column(length = 20)
    private String numero;

    @Column(length = 100)
    private String operador;

    @NotNull(message = "Debe indicar si este es su teléfono principal")
    private boolean principal;

    @NotBlank(message = "Debe indicar el estado del teléfono")
    @Column(length = 1)
    private String estado;

    @NotNull
    private boolean eliminado;

    @JsonBackReference
    @ManyToOne
    private Cliente cliente;

    public Telefono() {
        this.id = 0;
        this.numero = "";
        this.operador = "";
        this.principal = true;
        this.estado = "A";
        this.eliminado = false;
        this.cliente = new Cliente();
    }

    public Telefono(String numero, String operador, boolean principal) {
        this.numero = numero;
        this.operador = operador;
        this.principal = principal;
        this.estado = "A";
        this.eliminado = false;
        this.cliente = new Cliente();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
