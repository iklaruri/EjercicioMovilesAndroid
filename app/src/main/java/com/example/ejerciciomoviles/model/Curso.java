package com.example.ejerciciomoviles.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Curso")
public class Curso implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nombre, tipo, imagen;

    public Curso()
    {
    }

    @Ignore
    public Curso(String nombre, String imagen, String tipo)
    {
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
