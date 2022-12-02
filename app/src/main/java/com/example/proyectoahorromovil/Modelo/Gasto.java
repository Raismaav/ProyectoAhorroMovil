package com.example.proyectoahorromovil.Modelo;

public class Gasto {
    protected String Tipo, Lugar;
    protected int Resultado;

    public Gasto(String tipo, String lugar, int resultado) {
        this.Tipo = tipo;
        this.Lugar = lugar;
        this.Resultado = resultado;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String lugar) {
        Lugar = lugar;
    }

    public int getResultado() {
        return Resultado;
    }

    public void setResultado(int resultado) {
        Resultado = resultado;
    }
}
