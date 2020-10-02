package com.example.ejerciciomoviles.model;

public class Curso
{
    private String nombre, tipo;
    private int imagen;


    public Curso()
    {
    }

    public Curso(String nombre, int imagen, String tipo)
    {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getImagen()
    {
        return imagen;
    }

    public void setImagen(int imagen)
    {
        this.imagen = imagen;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
