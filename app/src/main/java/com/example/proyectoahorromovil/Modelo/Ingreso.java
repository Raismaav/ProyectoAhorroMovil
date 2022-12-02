package com.example.proyectoahorromovil.Modelo;

public class Ingreso extends Gasto{

    public Ingreso(String tipo, String lugar, int resultado) {
        super(tipo, lugar, resultado);
        this.Lugar="";
        this.Resultado= 0;
        this.Tipo="";
    }

}
