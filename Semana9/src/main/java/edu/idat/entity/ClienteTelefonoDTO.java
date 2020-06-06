package edu.idat.entity;

public class ClienteTelefonoDTO {
    private int clienteId;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private int anioNacimiento;
    private int telefonoId;
    private String numero;
    private String operador;

    public ClienteTelefonoDTO() {
        this.clienteId = 0;
        this.apellidoPaterno = "";
        this.apellidoMaterno = "";
        this.nombres = "";
        this.telefonoId = 0;
        this.numero = "";
        this.operador = "";
    }

    public ClienteTelefonoDTO(int clienteId, String apellidoPaterno, String apellidoMaterno, String nombres, int anioNacimiento, int telefonoId, String numero, String operador) {
        this.clienteId = clienteId;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.anioNacimiento = anioNacimiento;
        this.telefonoId = telefonoId;
        this.numero = numero;
        this.operador = operador;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
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

    public int getTelefonoId() {
        return telefonoId;
    }

    public void setTelefonoId(int telefonoId) {
        this.telefonoId = telefonoId;
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
}
