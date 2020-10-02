package com.example.ejerciciomoviles.ui.galeria;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ejerciciomoviles.R;

public class GaleriaFragment extends Fragment {

    private GaleriaViewModel galeriaViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galeriaViewModel =
                ViewModelProviders.of(this).get(GaleriaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_galeria, container, false);


        return root;
    }
}