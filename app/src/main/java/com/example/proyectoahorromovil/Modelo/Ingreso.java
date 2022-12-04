package com.example.proyectoahorromovil.Modelo;

public class Ingreso extends Movimientos {
    private String lugarIngreso, tipoIngreso;

    public Ingreso() {
    }

    public String getLugarIngreso() {
        return lugarIngreso;
    }

    public String getTipoIngreso() {
        return tipoIngreso;
    }

    public void setLugarIngreso(String lugarIngreso) {
        this.lugarIngreso = lugarIngreso;
    }

    public void setTipoIngreso(String tipoIngreso) {
        this.tipoIngreso = tipoIngreso;
    }
}
