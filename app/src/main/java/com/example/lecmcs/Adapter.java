package com.example.lecmcs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lecmcs.model.Tempat;


import java.util.Vector;

public class Adapter extends RecyclerView.Adapter<ViewHolder>{
    Context context;
    Vector<Tempat> tempat = new Vector<>();
    OnItemClickListener itemClick;
    Helper helper ;

    public Adapter(Context context, Vector<Tempat> tempat, OnItemClickListener itemClick) {
        this.context = context;
        Vector<Tempat> temp = new Vector<>();
        for(int i=tempat.size()-1;i>=0;i--){
            temp.add(tempat.get(i));
        }
        this.tempat = temp;
        this.itemClick = itemClick;
        helper= new Helper(context);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tempat tempats = tempat.get(position);
        holder.nama.setText(tempats.getNama());
        holder.lang.setText(String.valueOf("Longitude: "+tempats.getLang()));
        holder.lat.setText(String.valueOf( "Latitude: "+tempats.getLat()));
        holder.itemView.setOnClickListener(view ->{
            itemClick.onItemClick(tempat.get(position),position);
        });
        holder.btn.setOnClickListener(v -> {
            helper.dbDelete(tempat.get(position));
            tempat.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return tempat.size();
    }
    public interface OnItemClickListener {
        void onItemClick(Tempat tempat, int position);
    }
}
