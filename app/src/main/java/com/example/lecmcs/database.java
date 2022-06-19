package com.example.lecmcs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    public database(Context context) {
        super(context, "sqlite", null, 1);
    }
    private final String CREATE_TABLE_TEMPAT = "CREATE TABLE Tempat(TempatID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Lang Double not null," +
            "Lat Double not null," +
            "Nama TEXT not null)";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TEMPAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Tempat");
    }
}
