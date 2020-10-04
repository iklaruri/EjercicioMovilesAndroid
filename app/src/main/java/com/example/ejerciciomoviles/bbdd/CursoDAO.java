package com.example.ejerciciomoviles.bbdd;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ejerciciomoviles.model.Curso;

import java.util.List;

@Dao
public interface CursoDAO
{
    @Query("SELECT * FROM Curso ORDER BY ID")
    LiveData<List<Curso>> loadAllCursos();

    @Query("SELECT * FROM Curso WHERE id= :id")
    Curso loadCursoById(int id);

    @Insert
    void insertCurso(Curso curso);

    @Update
    void updateCurso(Curso curso);

    @Delete
    void delete(Curso curso);



}
