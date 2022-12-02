package com.example.proyectoahorromovil.Modelo;


import java.io.Serializable;

public class Movimientos implements Serializable {
    String NombreMovimiento, TipoMovimiento, FechaMovimiento;
    int MontoMovimiento;


    public Movimientos(String nombreMovimiento, String tipoMovimiento, String fechaMovimiento, int montoMovimiento) {
       this.NombreMovimiento = nombreMovimiento;
       this.TipoMovimiento = tipoMovimiento;
       this.FechaMovimiento = fechaMovimiento;
       this.MontoMovimiento = montoMovimiento;
    }

    public String getNombreMovimiento() {
        return NombreMovimiento;
    }

    public void setNombreMovimiento(String nombreMovimiento) {
        NombreMovimiento = nombreMovimiento;
    }

    public String getTipoMovimiento() {
        return TipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        TipoMovimiento = tipoMovimiento;
    }

    public String getFechaMovimiento() {
        return FechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        FechaMovimiento = fechaMovimiento;
    }

    public int getMontoMovimiento() {
        return MontoMovimiento;
    }

    public void setMontoMovimiento(int montoMovimiento) {
        MontoMovimiento = montoMovimiento;
    }
}



