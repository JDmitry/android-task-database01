package com.epam.database01.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private final static String DATABASE_NAME = "shop";
    private final static int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + "(" +
            FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FeedReaderContract.FeedEntry.COLUMN_SURNAME + " TEXT NOT NULL," +
            FeedReaderContract.FeedEntry.COLUMN_FIRST_NAME + " TEXT NOT NULL," +
            FeedReaderContract.FeedEntry.COLUMN_PATRONYMIC + " TEXT," +
            FeedReaderContract.FeedEntry.COLUMN_AGE + " INTEGER NOT NULL" + ");";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
