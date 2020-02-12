package com.epam.database01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class DBHelper extends SQLiteOpenHelper {
    final static String DB_NAME = "ListOfCustomers.db";
    final static int VERSION_DB = 1;


    public DBHelper(Context context) {
        super(context,DB_NAME, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Customers (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "SURNAME TEXT NOT NULL, " +
                "FIRSTNAME TEXT NOT NULL, " +
                "PATRONYMIC TEXT," +
                "AGE INTEGER NOT NULL " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customers");
    }
}
