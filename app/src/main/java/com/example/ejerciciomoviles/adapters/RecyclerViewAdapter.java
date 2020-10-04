package com.example.ejerciciomoviles.adapters;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ejerciciomoviles.MainActivity;
import com.example.ejerciciomoviles.R;
import com.example.ejerciciomoviles.model.Curso;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
{
    private final List<Curso> fotos;
    private Context miContext;

    public RecyclerViewAdapter(List<Curso> fotosList, Context context)
    {
        this.fotos = fotosList;
        this.miContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView ivFoto;
        public TextView tvFoto;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.ivFoto = itemView.findViewById(R.id.ivFoto);
            this.tvFoto = itemView.findViewById(R.id.tvFoto);
        }


        public ImageView getIvFoto()
        {
            return ivFoto;
        }

        public void setIvFoto(ImageView ivFoto)
        {
            this.ivFoto = ivFoto;
        }

        public TextView getTvFoto()
        {
            return tvFoto;
        }

        public void setTvFoto(TextView tvFoto)
        {
            this.tvFoto = tvFoto;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(this.miContext)
                .inflate(R.layout.recycler_view_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position)
    {

        final ImageView foto = holder.getIvFoto();
        final TextView texto = holder.getTvFoto();

        // Aqui utilizamos glide para insertar fotos
        Glide.with(miContext)
                .load(fotos.get(position).getImagen())
                .into(foto);

        texto.setText(fotos.get(position).getNombre());

        foto.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Bundle bundle = new Bundle();
                bundle.putString("fotoDialogText",texto.getText().toString());
                bundle.putString("fotoDialog",fotos.get(position).getImagen());
                clickFotoDialog(bundle);
            }
        });

    }

    private void clickFotoDialog(Bundle bundle)
    {
        final Dialog dialog = new Dialog(miContext);
        dialog.setContentView(R.layout.foto_dialog);
        ImageView ivDialogFoto = dialog.findViewById(R.id.ivFotoDialog);
        ivDialogFoto.setMinimumWidth(800);
        ivDialogFoto.setMinimumHeight(800);

        Glide.with(miContext)
                .load(bundle.getString("fotoDialog"))
                .into(ivDialogFoto);

        Toast.makeText(miContext.getApplicationContext(),bundle.getString("fotoDialogText") , Toast.LENGTH_SHORT).show();

        dialog.show();

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
            @Override
            public void onDismiss(DialogInterface dialog)
            {
                ((MainActivity) miContext).irGaleria();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return fotos.size();
    }



}
