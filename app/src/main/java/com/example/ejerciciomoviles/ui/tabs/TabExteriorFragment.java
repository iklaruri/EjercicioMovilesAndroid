package com.example.ejerciciomoviles.tabs;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejerciciomoviles.MainActivity;
import com.example.ejerciciomoviles.R;
import com.example.ejerciciomoviles.adapters.RecyclerViewAdapter;
import com.example.ejerciciomoviles.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class TabExteriorFragment extends Fragment
{
    private Context miContext;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter rvAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public static TabExteriorFragment newInstance()
    {
        return new TabExteriorFragment();
    }

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.miContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View vista = inflater.inflate(R.layout.tab_interior_fragment, container, false);
        recyclerView = vista.findViewById(R.id.rvInterior);

        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager =  new GridLayoutManager(miContext,3);
        recyclerView.setLayoutManager(layoutManager);

        final List<Curso> exteriores = new ArrayList<Curso>();

        for(int i = 0; i < ((MainActivity) miContext).getCursos().size(); i++)
        {
            if(((MainActivity) miContext).getCursos().get(i).getTipo().equals("E"))
            {
                exteriores.add(((MainActivity) miContext).getCursos().get(i));
            }
        }

        // specify an adapter (see also next example)
        rvAdapter = new RecyclerViewAdapter(exteriores,miContext);
        recyclerView.setAdapter(rvAdapter);

        return vista;
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState)
    {
        super.onViewStateRestored(savedInstanceState);
    }



}