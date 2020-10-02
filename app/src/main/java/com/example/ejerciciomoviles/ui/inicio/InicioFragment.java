package com.example.ejerciciomoviles.ui.inicio;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ejerciciomoviles.MainActivity;
import com.example.ejerciciomoviles.R;
import com.example.ejerciciomoviles.adapters.CursoAdapter;
import com.example.ejerciciomoviles.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class InicioFragment extends Fragment {

    private InicioViewModel inicioViewModel;
    private Context miContext;


    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        this.miContext = context;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Transition transition = TransitionInflater.from(miContext).inflateTransition(android.R.transition.explode);
        transition.setDuration(1000);
        setEnterTransition(transition);
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inicioViewModel = ViewModelProviders.of(this).get(InicioViewModel.class);
        inicioViewModel.getCursos().postValue(((MainActivity) miContext).getCursos());
        View vista = inflater.inflate(R.layout.fragment_inicio, container, false);
        final ListView lvCursos = vista.findViewById(R.id.lvCursos);
        inicioViewModel.getCursos().observe(getViewLifecycleOwner(), new Observer<List<Curso>>()
        {
            @Override
            public void onChanged(List<Curso> cursos)
            {
                lvCursos.setAdapter(new CursoAdapter(getContext(),cursos));
            }
        });
        return vista;
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