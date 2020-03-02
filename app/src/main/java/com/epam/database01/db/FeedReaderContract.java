package com.epam.database01.db;

import android.provider.BaseColumns;

final class FeedReaderContract {
    private FeedReaderContract() {}

    static class FeedEntry implements BaseColumns {
        static final String TABLE_NAME = "customers";
        static final String COLUMN_SURNAME = "surname";
        static final String COLUMN_FIRST_NAME = "firstname";
        static final String COLUMN_PATRONYMIC = "patronymic";
        static final String COLUMN_AGE = "age";
        static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + "(" +
                FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FeedReaderContract.FeedEntry.COLUMN_SURNAME + " TEXT NOT NULL," +
                FeedReaderContract.FeedEntry.COLUMN_FIRST_NAME + " TEXT NOT NULL," +
                FeedReaderContract.FeedEntry.COLUMN_PATRONYMIC + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_AGE + " INTEGER NOT NULL" + ");";
        static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;
        static final String SQL_QUERY = "SELECT * FROM ";
    }
}
