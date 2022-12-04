package com.example.proyectoahorromovil.Modelo;

import java.io.Serializable;

public class Movimientos implements Serializable {

    String NombreMovimiento, TipoMovimiento, FechaMovimiento;
    int MontoMovimiento;

    public Movimientos() {
    }

    public String getNombreMovimiento() { return NombreMovimiento; }
    public void setNombreMovimiento(String nombreMovimiento) { NombreMovimiento = nombreMovimiento; }
    public String getTipoMovimiento() { return TipoMovimiento; }
    public void setTipoMovimiento(String tipoMovimiento) { TipoMovimiento = tipoMovimiento; }
    public String getFechaMovimiento() { return FechaMovimiento; }
    public void setFechaMovimiento(String fechaMovimiento) { FechaMovimiento = fechaMovimiento; }
    public int getMontoMovimiento() { return MontoMovimiento; }
    public void setMontoMovimiento(int montoMovimiento) { MontoMovimiento = montoMovimiento; }
}



