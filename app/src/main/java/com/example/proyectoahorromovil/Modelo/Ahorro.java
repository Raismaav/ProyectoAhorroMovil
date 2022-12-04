package com.example.proyectoahorromovil.Modelo;

public class Ahorro {
    String NombreBeneficiario, TipoAhorro, FechaAhorro, CuentaAhorro;
    int MontoAhorro;

    public Ahorro() {

    }

    public String getNombreBeneficiario() {
        return NombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        NombreBeneficiario = nombreBeneficiario;
    }

    public String getTipoAhorro() {
        return TipoAhorro;
    }

    public void setTipoAhorro(String tipoAhorro) {
        TipoAhorro = tipoAhorro;
    }

    public String getFechaAhorro() {
        return FechaAhorro;
    }

    public void setFechaAhorro(String fechaAhorro) {
        FechaAhorro = fechaAhorro;
    }

    public String getCuentaAhorro() {
        return CuentaAhorro;
    }

    public void setCuentaAhorro(String cuentaAhorro) {
        CuentaAhorro = cuentaAhorro;
    }

    public int getMontoAhorro() {
        return MontoAhorro;
    }

    public void setMontoAhorro(int montoAhorro) {
        MontoAhorro = montoAhorro;
    }
}
