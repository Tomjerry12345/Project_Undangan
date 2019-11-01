package com.example.projectundangan.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.projectundangan.model.Tamu;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;


import static com.example.projectundangan.db.DatabaseContract.DaftarTamu.ALAMAT;
import static com.example.projectundangan.db.DatabaseContract.DaftarTamu.NAMA;
import static com.example.projectundangan.db.DatabaseContract.TABLE_TAMU;

public class TamuHelper {
    public static final String DATABASE_TABLE = TABLE_TAMU;
    private static DatabaseHelper databaseHelper;
    private static  TamuHelper INSTANCE;


    private static SQLiteDatabase database;


    public TamuHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static TamuHelper getInstance(Context context){
        if (INSTANCE == null){
            synchronized (SQLiteOpenHelper.class){
                if (INSTANCE == null){
                    INSTANCE = new TamuHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close(){
        databaseHelper.close();
        if (database.isOpen()){
            database.close();
        }
    }

    public ArrayList<Tamu>getAllTamu(){
        ArrayList<Tamu> arrayList =new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                _ID + " ASC",
                null);
        cursor.moveToFirst();
        Tamu modelTamu;
        if (cursor.getCount() > 0){
            do {
                modelTamu = new Tamu();
                modelTamu.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                modelTamu.setNama(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)));

                arrayList.add(modelTamu);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }


    public long insertTamu (Tamu modelTamu){
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMA, modelTamu.getNama());
        contentValues.put(ALAMAT , modelTamu.getAlamat());
//        Log.i(TAG, modelMovie.getTitle());
        return database.insert(DATABASE_TABLE, null, contentValues);
    }


    public int deleteTamu(int id){
        return database.delete(TABLE_TAMU, _ID +"= '"+id+"'", null);
    }

}
