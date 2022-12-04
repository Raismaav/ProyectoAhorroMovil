package com.example.proyectoahorromovil.Modelo;

public class Ahorro {

    String nombreBeneficiario, tipoAhorro, fechaAhorro, cuentaAhorro;
    int montoAhorro;

    public Ahorro() { /* Constructor vacío */}

    public String getNombreBeneficiario() { return nombreBeneficiario; }
    public void setNombreBeneficiario(String nombreBeneficiario) { this.nombreBeneficiario = nombreBeneficiario; }
    public String getTipoAhorro() { return tipoAhorro; }
    public void setTipoAhorro(String tipoAhorro) { this.tipoAhorro = tipoAhorro; }
    public String getFechaAhorro() { return fechaAhorro; }
    public void setFechaAhorro(String fechaAhorro) { this.fechaAhorro = fechaAhorro; }
    public String getCuentaAhorro() { return cuentaAhorro; }
    public void setCuentaAhorro(String cuentaAhorro) { this.cuentaAhorro = cuentaAhorro; }
    public int getMontoAhorro() { return montoAhorro; }
    public void setMontoAhorro(int montoAhorro) { this.montoAhorro = montoAhorro; }
}
