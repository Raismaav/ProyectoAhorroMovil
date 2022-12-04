package com.example.proyectoahorromovil.Modelo;

public class Inversion {

    String NombreInversion,TipoInversion, NivelRiesgo, PlazoInversion, ObjetivoInversion;
    int MontoInversion;

    public Inversion() { /* Constructor vacío */ }

    public String getNombreInversion() { return NombreInversion; }
    public void setNombreInversion(String nombreInversion) { NombreInversion = nombreInversion; }
    public String getTipoInversion() { return TipoInversion; }
    public void setTipoInversion(String tipoInversion) { TipoInversion = tipoInversion; }
    public String getNivelRiesgo() { return NivelRiesgo; }
    public void setNivelRiesgo(String nivelRiesgo) { NivelRiesgo = nivelRiesgo; }
    public String getPlazoInversion() { return PlazoInversion; }
    public void setPlazoInversion(String plazoInversion) { PlazoInversion = plazoInversion; }
    public String getObjetivoInversion() { return ObjetivoInversion; }
    public void setObjetivoInversion(String objetivoInversion) { ObjetivoInversion = objetivoInversion; }
    public int getMontoInversion() { return MontoInversion; }
    public void setMontoInversion(int montoInversion) { MontoInversion = montoInversion; }
}
