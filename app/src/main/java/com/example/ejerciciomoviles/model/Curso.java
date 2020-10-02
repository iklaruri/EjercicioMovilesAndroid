package com.example.ejerciciomoviles.model;

public class Curso
{
    private String nombre,imagen;

    public Curso()
    {
    }

    public Curso(String nombre, String imagen)
    {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getImagen()
    {
        return imagen;
    }

    public void setImagen(String imagen)
    {
        this.imagen = imagen;
    }
}
