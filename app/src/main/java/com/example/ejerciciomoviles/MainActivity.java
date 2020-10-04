package com.example.ejerciciomoviles;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.example.ejerciciomoviles.bbdd.AppDatabase;
import com.example.ejerciciomoviles.bbdd.AppExecutors;
import com.example.ejerciciomoviles.interfaces.ICursos;
import com.example.ejerciciomoviles.model.Curso;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ICursos
{

    private AppBarConfiguration mAppBarConfiguration;
    private AppDatabase mDB = null;
    private List<Curso> cursos = new ArrayList<Curso>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);

        mDB = AppDatabase.getInstance(getApplicationContext());
        File bd = getDatabasePath("cursosBD");

        if (!bd.exists())
        {
            rellenarBD();
        }

        cargarCursos();
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio, R.id.nav_galeria, R.id.nav_mapa)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        View header = navigationView.getHeaderView(0);
        ImageView imgMenu = header.findViewById(R.id.ivLogo);

        imgMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                drawer.closeDrawer(GravityCompat.START);
                irInicio();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void rellenarBD()
    {
        AppExecutors.getsInstance().getDiskIP().execute(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < cargarCursos().size(); i++){
                    mDB.cursoDAO().insertCurso(cargarCursos().get(i));
                }

            }
        });
    }

    @Override
    public List<Curso> cargarCursos()
    {
        Curso curso1 = new Curso("DAM 1","https://almi.eus/wp-content/uploads/2016/05/logo.png","I");
        Curso curso2 = new Curso("DAM 2","https://almi.eus/wp-content/uploads/2016/05/logo.png","I");
        Curso curso3 = new Curso("SMR 1","https://almi.eus/wp-content/uploads/2016/05/logo.png","I");
        Curso curso4 = new Curso("SMR 2","https://almi.eus/wp-content/uploads/2016/05/logo.png","I");
        Curso curso5 = new Curso("AG 1","https://almi.eus/wp-content/uploads/2016/05/logo.png","I");
        Curso curso6 = new Curso("AG 2","https://almi.eus/wp-content/uploads/2016/05/logo.png","E");
        Curso curso7 = new Curso("STI 1","https://almi.eus/wp-content/uploads/2016/05/logo.png","E");
        Curso curso8 = new Curso("STI 2","https://almi.eus/wp-content/uploads/2016/05/logo.png","E");
        Curso curso9 = new Curso("DAW 1","https://almi.eus/wp-content/uploads/2016/05/logo.png","E");
        Curso curso10 = new Curso("DAW 2","https://almi.eus/wp-content/uploads/2016/05/logo.png","E");

        cursos.add(curso1);
        cursos.add(curso2);
        cursos.add(curso3);
        cursos.add(curso4);
        cursos.add(curso5);
        cursos.add(curso6);
        cursos.add(curso7);
        cursos.add(curso8);
        cursos.add(curso9);
        cursos.add(curso10);

        return cursos;

    }

    @Override
    public void irInicio()
    {
        Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.nav_inicio);
    }

    public void irGaleria()
    {
        Navigation.findNavController(this,R.id.nav_host_fragment).navigate(R.id.nav_galeria);
    }

    public List<Curso> getCursos()
    {
        return cursos;
    }




}