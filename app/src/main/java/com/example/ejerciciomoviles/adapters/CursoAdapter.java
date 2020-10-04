package com.example.ejerciciomoviles.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ejerciciomoviles.R;
import com.example.ejerciciomoviles.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoAdapter extends BaseAdapter
{
    private Context miContext;
    private List<Curso> cursos;

    public CursoAdapter(Context context, List<Curso> cursos)
    {
        this.miContext = context;
        this.cursos = cursos;
    }

    @Override
    public int getCount()
    {
        if(cursos != null & cursos.size() != 0)
        {
            return cursos.size();
        }else{
            return 0;
        }

    }

    @Override
    public Object getItem(int position)
    {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(this.miContext);
        View fila = inflater.inflate(R.layout.curso_item,parent,false);

        TextView tvNombre = fila.findViewById(R.id.tvCurso);
        tvNombre.setText(cursos.get(position).getNombre());

        return fila;
    }


}
