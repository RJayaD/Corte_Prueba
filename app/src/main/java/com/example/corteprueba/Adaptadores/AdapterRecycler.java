package com.example.corteprueba.Adaptadores;
import com.example.corteprueba.*;
import com.example.corteprueba.Models.*;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtPais;
        ImageView Img;

        public ViewHolder( View itemView) {
            super(itemView);
            txtPais=(TextView)itemView.findViewById(R.id.textPais);
            Img = (ImageView) itemView.findViewById(R.id.img_P);
        }
    }
    public List<Datum> Data;

    public AdapterRecycler(List<Datum> data) {
        Log.i("TAG", "Error" + data.size());
        Data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_prueba,parent,false);
        ViewHolder viewHolder= new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.txtPais.setText(Data.get(position).getName());

        Glide.with(holder.Img.getContext())
                .load(Data.get(position).getAlpha2Code())
                .into(holder.Img);
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }
}
