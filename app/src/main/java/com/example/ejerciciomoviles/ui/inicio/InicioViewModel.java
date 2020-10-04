package com.example.ejerciciomoviles.ui.inicio;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ejerciciomoviles.MainActivity;
import com.example.ejerciciomoviles.bbdd.AppDatabase;
import com.example.ejerciciomoviles.bbdd.CursoDAO;
import com.example.ejerciciomoviles.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class InicioViewModel extends AndroidViewModel
{

    private CursoDAO cursoDAO;

    public InicioViewModel(@NonNull Application application)
    {
        super(application);
        /*this.cursos = new MutableLiveData<List<Curso>>();
        List<Curso> c = new ArrayList<Curso>();
        this.cursos.postValue(c);*/
        cursoDAO = AppDatabase.getInstance(application).cursoDAO();

    }


    public LiveData<List<Curso>> getAllCursos()
    {
        return cursoDAO.loadAllCursos();
    }

   /* public void setCursos(MutableLiveData<List<Curso>> cursos)
    {
        this.cursos = cursos;
    }*/
}