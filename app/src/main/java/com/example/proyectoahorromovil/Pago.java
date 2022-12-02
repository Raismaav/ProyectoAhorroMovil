package com.example.proyectoahorromovil;

public class Pago {
    String ClaveRastreo, FechaPago, Emisor, Receptor;
    int CuentaBeneficiaria, MontoPago;

    public Pago(String claveRastreo, String fechaPago, String emisor, String receptor, int cuentaBeneficiaria, int montoPago) {
        this.ClaveRastreo = claveRastreo;
        this.FechaPago = fechaPago;
        this.Emisor = emisor;
        this.Receptor = receptor;
        this.CuentaBeneficiaria = cuentaBeneficiaria;
        this.MontoPago = montoPago;
    }

    public String getClaveRastreo() {
        return ClaveRastreo;
    }

    public void setClaveRastreo(String claveRastreo) {
        ClaveRastreo = claveRastreo;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String fechaPago) {
        FechaPago = fechaPago;
    }

    public String getEmisor() {
        return Emisor;
    }

    public void setEmisor(String emisor) {
        Emisor = emisor;
    }

    public String getReceptor() {
        return Receptor;
    }

    public void setReceptor(String receptor) {
        Receptor = receptor;
    }

    public int getCuentaBeneficiaria() {
        return CuentaBeneficiaria;
    }

    public void setCuentaBeneficiaria(int cuentaBeneficiaria) {
        CuentaBeneficiaria = cuentaBeneficiaria;
    }

    public int getMontoPago() {
        return MontoPago;
    }

    public void setMontoPago(int montoPago) {
        MontoPago = montoPago;
    }
}
