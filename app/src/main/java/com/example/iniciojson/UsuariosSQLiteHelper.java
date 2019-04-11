package com.example.iniciojson;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

    String sqlDataBase = "CREATE TABLE Items (codigo INTEGER, nombre TEXT)";

    public UsuariosSQLiteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super( contexto, nombre, factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlDataBase);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS Items");

        db.execSQL(sqlDataBase);
    }
}
