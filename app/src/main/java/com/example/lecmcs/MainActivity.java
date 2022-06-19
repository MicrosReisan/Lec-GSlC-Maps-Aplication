package com.example.lecmcs;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lecmcs.model.Tempat;


import java.util.Collections;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Helper helper;
    Button btnadd;
    EditText etlang, etlat,etnama;
    int Count=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        btnadd = findViewById(R.id.btnadd);
        etlang = findViewById(R.id.etLang);
        etlat = findViewById(R.id.etLat);
        etnama = findViewById(R.id.etnama);

        helper = new Helper(this);
        btnadd.setOnClickListener(v -> {
            String langtext =etlang.getText().toString();
            String lattext =etlat.getText().toString();
            String nametext = etnama.getText().toString();
            if(!lattext.matches("^[0-9]*$") || !langtext.matches("^[0-9]*$") ){
                Toast.makeText(this,"longitude and lattitude must be number",Toast.LENGTH_SHORT).show();

            }
            else if(lattext.isEmpty()|| langtext.isEmpty()){
                Toast.makeText(this,"longitude and lattitude must be filled",Toast.LENGTH_SHORT).show();
            }
            else{
                if(nametext.isEmpty()){
                    nametext = "Tempat"+Count;
                    Count++;
                }
                helper.dbInsert(new Tempat(nametext,Double.parseDouble(langtext),Double.parseDouble(lattext)));
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }

        });
        Adapter adapter = new Adapter(this, helper.dbRead(),new Adapter.OnItemClickListener(){

            @Override
            public void onItemClick(Tempat tempat, int position) {
                Intent inMaps = new Intent(MainActivity.this,MapsActivity.class);
                inMaps.putExtra("name",tempat.getNama());
                inMaps.putExtra("lang",tempat.getLang());
                inMaps.putExtra("lat",tempat.getLat());
                startActivity(inMaps);
            }
        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
    }
}