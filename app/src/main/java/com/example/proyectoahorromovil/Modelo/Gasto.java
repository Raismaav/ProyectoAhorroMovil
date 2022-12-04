package com.example.proyectoahorromovil.Modelo;

public class Gasto extends Movimientos {

    protected String tipoGasto, lugarGasto;

    public Gasto() { /* Constructor vacío */ }

    public String getTipoGasto() { return tipoGasto; }
    public void setTipoGasto(String tipoGasto) { this.tipoGasto = tipoGasto; }
    public String getLugarGasto() { return lugarGasto; }
    public void setLugarGasto(String lugarGasto) { this.lugarGasto = lugarGasto; }
}
