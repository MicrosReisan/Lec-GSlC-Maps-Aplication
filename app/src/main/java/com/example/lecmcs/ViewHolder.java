package com.example.lecmcs;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView nama,lang,lat;
    Button btn;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        nama = itemView.findViewById(R.id.tvnama);
        lang = itemView.findViewById(R.id.tvlang);
        lat = itemView.findViewById(R.id.tvlat);
        btn = itemView.findViewById(R.id.buttondelete);
    }
}
