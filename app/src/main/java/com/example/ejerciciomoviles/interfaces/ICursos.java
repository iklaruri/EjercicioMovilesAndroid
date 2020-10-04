package com.example.ejerciciomoviles.interfaces;

import com.example.ejerciciomoviles.model.Curso;

import java.util.List;

public interface ICursos
{
    public void rellenarBD();
    public List<Curso> cargarCursos();
    public void irInicio();
}
