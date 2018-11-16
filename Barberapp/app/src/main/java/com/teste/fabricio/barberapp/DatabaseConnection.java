package com.teste.fabricio.barberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseConnection {
    static private SQLiteDatabase connection = null;
    static private String database = "";
    static private Context context;

    public static void setConfig(String db, Context c) {
        database = db;
        context = c;
    }

    public static SQLiteDatabase getConnection() {
        if (connection == null) {
            try {
                connection = context.openOrCreateDatabase(database, 0, null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
