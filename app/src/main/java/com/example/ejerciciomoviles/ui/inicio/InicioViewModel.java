package com.example.ejerciciomoviles.ui.inicio;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ejerciciomoviles.MainActivity;
import com.example.ejerciciomoviles.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class InicioViewModel extends AndroidViewModel
{

    private MutableLiveData<List<Curso>> cursos;

    public InicioViewModel(@NonNull Application application)
    {
        super(application);
        this.cursos = new MutableLiveData<List<Curso>>();
        List<Curso> c = new ArrayList<Curso>();
        this.cursos.postValue(c);
    }


    public MutableLiveData<List<Curso>> getCursos()
    {
        return cursos;
    }

    public void setCursos(MutableLiveData<List<Curso>> cursos)
    {
        this.cursos = cursos;
    }
}