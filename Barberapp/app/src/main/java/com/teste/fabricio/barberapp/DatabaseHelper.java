package com.teste.fabricio.barberapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "barberapp.db";
    private static final int DATABASE_VERSION = 1;
    private static Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static void setContext(Context c) {
        context = c;
    }

    public static SQLiteDatabase getConnection() {
        return new DatabaseHelper(context).getWritableDatabase();
    }
}