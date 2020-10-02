package com.example.ejerciciomoviles.ui.galeria;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.ejerciciomoviles.R;
import com.example.ejerciciomoviles.adapters.TabViewPagerAdapter;

import com.example.ejerciciomoviles.ui.tabs.TabExteriorFragment;
import com.example.ejerciciomoviles.ui.tabs.TabInteriorFragment;
import com.google.android.material.tabs.TabLayout;

public class GaleriaFragment extends Fragment {

    private GaleriaViewModel galeriaViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
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
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galeriaViewModel =
                ViewModelProviders.of(this).get(GaleriaViewModel.class);
        View vista = inflater.inflate(R.layout.fragment_galeria, container, false);

        tabLayout = vista.findViewById(R.id.tabs);
        viewPager = vista.findViewById(R.id.vPager);

        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });

        return vista;
    }

    public void setUpViewPager(ViewPager viewPager)
    {
        TabViewPagerAdapter tabViewPagerAdapter = new TabViewPagerAdapter(getChildFragmentManager());
        tabViewPagerAdapter.addFragment(new TabInteriorFragment(),"Interior");
        tabViewPagerAdapter.addFragment(new TabExteriorFragment(),"Exterior");
        viewPager.setAdapter(tabViewPagerAdapter);
    }


}