package com.example.proyectoahorromovil.Modelo;

public class Pago {

    String claveRastreo, fechaPago, emisor, receptor;
    int cuentaBeneficiaria, montoPago;

    public Pago() { /* Constructor vacío */ }

    public String getClaveRastreo() { return claveRastreo; }
    public void setClaveRastreo(String claveRastreo) { this.claveRastreo = claveRastreo; }
    public String getFechaPago() { return fechaPago; }
    public void setFechaPago(String fechaPago) { this.fechaPago = fechaPago; }
    public String getEmisor() { return emisor; }
    public void setEmisor(String emisor) { this.emisor = emisor; }
    public String getReceptor() { return receptor; }
    public void setReceptor(String receptor) { this.receptor = receptor; }
    public int getCuentaBeneficiaria() { return cuentaBeneficiaria; }
    public void setCuentaBeneficiaria(int cuentaBeneficiaria) { this.cuentaBeneficiaria = cuentaBeneficiaria; }
    public int getMontoPago() { return montoPago; }
    public void setMontoPago(int montoPago) { this.montoPago = montoPago; }
}

