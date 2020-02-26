package com.epam.database01;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.epam.database01.db.DBHelper;
import com.epam.database01.db.FeedReaderContract;

class Insert {
    Insert(InsertActivity insertActivity, String surname, String firstName, String patronymic, int age) {
        DBHelper helper = new DBHelper(insertActivity);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_SURNAME, surname);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_FIRST_NAME, firstName);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_PATRONYMIC, patronymic);
        contentValues.put(FeedReaderContract.FeedEntry.COLUMN_AGE, age);

        long newRow = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, contentValues);
    }
}
