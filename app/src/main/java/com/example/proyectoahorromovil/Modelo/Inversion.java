package com.example.proyectoahorromovil.Modelo;

public class Inversion {
    String NombreInversionista,TipoInversion, NivelRiesgo, PlazoInversion;
    int ObjetivoInversion,MontoInversion;

    public Inversion(String nombreInversionista, String tipoInversion, String nivelRiesgo, String plazoInversion, int objetivoInversion, int montoInversion) {
        this.NombreInversionista = nombreInversionista;
        this.TipoInversion = tipoInversion;
        this.NivelRiesgo = nivelRiesgo;
        this.PlazoInversion = plazoInversion;
        this.ObjetivoInversion = objetivoInversion;
        this.MontoInversion = montoInversion;
    }

    public String getNombreInversionista() {
        return NombreInversionista;
    }

    public void setNombreInversionista(String nombreInversionista) {
        NombreInversionista = nombreInversionista;
    }

    public String getTipoInversion() {
        return TipoInversion;
    }

    public void setTipoInversion(String tipoInversion) {
        TipoInversion = tipoInversion;
    }

    public String getNivelRiesgo() {
        return NivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        NivelRiesgo = nivelRiesgo;
    }

    public String getPlazoInversion() {
        return PlazoInversion;
    }

    public void setPlazoInversion(String plazoInversion) {
        PlazoInversion = plazoInversion;
    }

    public int getObjetivoInversion() {
        return ObjetivoInversion;
    }

    public void setObjetivoInversion(int objetivoInversion) {
        ObjetivoInversion = objetivoInversion;
    }

    public int getMontoInversion() {
        return MontoInversion;
    }

    public void setMontoInversion(int montoInversion) {
        MontoInversion = montoInversion;
    }
}
