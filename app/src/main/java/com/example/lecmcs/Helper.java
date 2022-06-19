package com.example.lecmcs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lecmcs.model.Tempat;

import java.util.Vector;

public class Helper {
    private final String TABLE_NAME = "Tempat";
    private database databases;
    private SQLiteDatabase db;

    public Helper(Context context){
        databases = new database(context);
    }
    public void dbInsert(Tempat tempat){
        db = databases.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Lang", tempat.getLang());
        cv.put("Lat", tempat.getLat());
        cv.put("nama", tempat.getNama());

        db.insert(TABLE_NAME, null, cv);
        db.close();
    }
    public Vector<Tempat> dbRead(){
        Vector<Tempat> tempats = new Vector<>();
        db = databases.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Tempat", null);
        cursor.moveToFirst();

        Tempat temp;
        String tempName;
        Double tempLat,tempLang;


        if (cursor != null && cursor.getCount() > 0){
            do {
                tempName = cursor.getString(cursor.getColumnIndexOrThrow("Nama"));
                tempLang = cursor.getDouble(cursor.getColumnIndexOrThrow("Lang"));
                tempLat = cursor.getDouble(cursor.getColumnIndexOrThrow("Lat"));

                temp = new Tempat(tempName,tempLang,tempLat);
                tempats.add(temp);

                cursor.moveToNext();

            } while (!cursor.isAfterLast());
            cursor.close();
        }
        db.close();
        return tempats;


    }
    public void dbDelete(Tempat tempat ){
        db = databases.getWritableDatabase();
        db.delete(TABLE_NAME,
                "Nama = ?", new String[]{tempat.getNama() + ""});
        db.close();
    }
}
