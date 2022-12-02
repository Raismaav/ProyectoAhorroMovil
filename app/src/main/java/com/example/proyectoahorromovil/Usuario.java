package com.example.proyectoahorromovil;

public class Usuario {
    String Nombre, Apellido, Sexo,Usuario, Contraseña;
    int Edad;

    public Usuario(String nombre, String apellido, String sexo, String usuario, String contraseña, int edad) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Sexo = sexo;
        this.Usuario = usuario;
        this.Contraseña = contraseña;
        this.Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }
}
